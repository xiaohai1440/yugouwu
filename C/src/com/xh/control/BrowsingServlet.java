package com.xh.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.spy.memcached.MemcachedClient;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xh.bean.Browsing;
import com.xh.bean.Product;
import com.xh.bean.User;
import com.xh.service.BrowsingService;
import com.xh.service.ProductService;
import com.xh.servicelmpl.BrowsingServiceImpl;
import com.xh.servicelmpl.ProductServiceImpl;
import com.xh.util.Memcached;


@WebServlet("/BrowsingServlet1")
public class BrowsingServlet extends HttpServlet {


	BrowsingService b=new BrowsingServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//"BrowsingServlet1?method=2"
		String key=req.getParameter("method");
		String parameter2 = req.getParameter("userliulan");
		
		System.err.println("=========================》"+key+"ddddd"+parameter2);
		switch (key) {
		case "1":

			Browsingjl(req,resp);

			break;
		case "2":

			Browsingcx(req,resp);

			break;
		case "3":
			Browsingjl(req,resp);
			break;
		case "4":

			break;

		default:
			break;
		}




	}

	private void Browsingcx(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

		List<Browsing> select = b.selectAllId(((User)(req.getSession().getAttribute("user"))).getId());	

		System.err.println(select+"......................");



		ProductService product = new ProductServiceImpl();


		Product select_Id = null;

		//List<Product> products=new ArrayList<>();
		Map<String, Product> products=new LinkedHashMap<>();

		for (Browsing browsing : select) {


			select_Id = product.select_Id(browsing.getProductId());


			products.put(browsing.getCreateTime(), select_Id);



		}

		try {
			req.setAttribute("selectzj", products);
			req.getRequestDispatcher("my-zuji.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//my-zuji.jsp

	}


	/**
	 * 
	 * @param req
	 * @param resp   记录浏览记录的方法》》加缓存   问题是：是登录的时候就请求查询浏览记录，还是说点击查询在去查询
	 */
	private void Browsingjl(HttpServletRequest req, HttpServletResponse resp) {



		System.err.println("============>Browsingjl");

		MemcachedClient in = Memcached.getIn();	
		
		String parameter2 = req.getParameter("userliulan");	
		
		Integer id = ((User)(req.getSession().getAttribute("user"))).getId();
		
		List<Browsing> select=b.selectAllId(id);
		
		/*List<Browsing> select=(List<Browsing>) in.get(id+"liulanzuji");	*/

		//Product productId = (Product) req.getAttribute("product");	
		boolean falg=false;	
		if (select!=null&&select.size()>0) {

			for (Browsing browsing : select) {		
				if (parameter2.equals(browsing.getProductId().toString())) {	


					browsing.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
					in.set(id+"liulanzuji", 60*30, select);	
					falg=true;

					break;			
				}					
			}
			if (!falg) {
				String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
				Browsing b=new Browsing(null,id, Integer.valueOf(parameter2),format);
				select.add(0, b);
				in.set(id+"liulanzuji", 60*30, select);	

			}




		}else {	
			//是没有浏览记录的
			
			String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			Browsing b=new Browsing(null,id, Integer.valueOf(parameter2),format);
			select.add(b);	 
			in.set(id+"liulanzuji", 60*30, select);

		}

	}

}

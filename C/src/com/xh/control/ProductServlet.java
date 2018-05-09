package com.xh.control;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.spy.memcached.MemcachedClient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xh.bean.Browsing;
import com.xh.bean.Product;
import com.xh.bean.User;
import com.xh.service.BrowsingService;
import com.xh.service.ProductService;
import com.xh.servicelmpl.BrowsingServiceImpl;
import com.xh.servicelmpl.ProductServiceImpl;
import com.xh.util.Memcached;


@WebServlet("/ProductServlet")

/**
 * 
 *商品Servlet
 * @author Macro
 *
 */
public class ProductServlet extends HttpServlet{


	ProductService service=new ProductServiceImpl();



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("进入====================》ProductServlet-------------》");
		String page=req.getParameter("method");

		switch (page) {

		case "like":

			getProductLike(req,resp);

			break;

		case "sanjiye":
			getProductCategoryESanJi(req,resp);

			break;

		case "finId":
			System.out.println("进入====================》finId");
			finById(req, resp);
			
			
			
			
			User user = (User) req.getSession().getAttribute("user");
			if (user!=null) {
				
				browsingjl(req,resp);
				//req.setAttribute("product", product);
					/*System.err.println("444444444>>>>>>>>>>>>>>>>>>"+req.getParameter("id"));
					
					resp.sendRedirect("BrowsingServlet1?method=1&userliulan="+req.getParameter("id"));*/
				    //req.getRequestDispatcher("BrowsingServlet1?method=1&userliulan="+req.getParameter("id")).forward(req, resp);/*").sendRedirect("BrowsingServlet1?method=1&userliulan="+req.getParameter("id"));
					//req.getRequestDispatcher("BrowsingServlet1?method=1&user="+user.getId()).forward(req, resp);

			}
	
			break;
		case "def":
			getProduct(resp);
			break;
		case "addcar":
			System.out.println("进入====================》addcar");
			
			
			/*User user=(User) req.getSession().getAttribute("user");
			if(user!=null){

				service.add(t)
			}*/
			break;	
		default:

			break;
		}

	}


	private void getProductLike(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub


		List<Product> selectLike = service.selectLike(req.getParameter("pageNum"));

		if (selectLike==null) {

			Product product = new Product();
			product.setName("没有这商品！");
			selectLike.add(product);

		}

		Gson gson =new GsonBuilder().create();//转换时间格式

		/*	for (Product product : list) {
					System.err.println(product);
					System.err.println("ProductProductProductProductProduct==============》");
				}*/
		String json = gson.toJson(selectLike); 
		System.out.println("json:"+json);
		PrintWriter writer=null;
		try {
			writer = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.print(json); // 返回数据给前台
		writer.close();




	}

	private void getProductCategoryESanJi(HttpServletRequest req,
			HttpServletResponse resp) {




		List<Product> nameList =service.select(req.getParameter("id"));
		System.err.println("===================asasa");
		req.setAttribute("mingzi", req.getParameter("mingzi"));
		req.setAttribute("nameList", nameList);

		try {
			req.getRequestDispatcher("my-all.jsp").forward(req, resp);

		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
	private void browsingjl(HttpServletRequest req, HttpServletResponse resp) {

		BrowsingService b1=new BrowsingServiceImpl();

		System.err.println("============>Browsingjl");

		MemcachedClient in = Memcached.getIn();	
		
		String parameter2 = req.getParameter("id");	
		
		Integer id = ((User)(req.getSession().getAttribute("user"))).getId();
		
		List<Browsing> select=b1.selectAllId(id);
		
		/*List<Browsing> select=(List<Browsing>) in.get(id+"liulanzuji");	*/

		//Product productId = (Product) req.getAttribute("product");	
		boolean falg=false;	
		if (select!=null&&select.size()>0) {

			for (Browsing browsing : select) {		
				
				if (parameter2.equals(browsing.getProductId()+"")) {	


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


	private void finById(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("id==============qqqq>"+req.getParameter("id"));
		Product product=service.select_Id(req.getParameter("id"));
		
		//User user = (User) req.getSession().getAttribute("user");
		


		Gson gson =new GsonBuilder()
		.create();
		String json = gson.toJson(product); 
		System.out.println("json----->:"+json);
		PrintWriter writer = resp.getWriter();
		writer.print(json); // 返回数据给前台	
		writer.close();
	
		
		

		
	}

	private void getProduct(HttpServletResponse resp) throws IOException {
		List<Product> list=service.select();
		Gson gson =new GsonBuilder().create();//转换时间格式

		/*	for (Product product : list) {
			System.err.println(product);
			System.err.println("ProductProductProductProductProduct==============》");
		}*/
		String json = gson.toJson(list); 
		System.out.println("json:"+json);
		PrintWriter writer = resp.getWriter();
		writer.print(json); // 返回数据给前台
		writer.close();
	}

}

package com.xh.control;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xh.bean.Product;
import com.xh.bean.User;
import com.xh.service.ProductService;
import com.xh.servicelmpl.ProductServiceImpl;


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
		System.out.println("进入====================》ProductServlet");
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
			break;
		case "def":
			getProduct(resp);
			break;
		case "addcar":
			System.out.println("进入====================》addcar");
			User user=(User) req.getSession().getAttribute("user");
			if(user!=null){
				
				/*service.add(t)*/
			}
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


	private void finById(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("id===============>"+req.getParameter("id"));
		Product product=service.select_Id(req.getParameter("id"));
		Gson gson =new GsonBuilder()
		.create();
		String json = gson.toJson(product); 
		System.out.println("json:"+json);
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

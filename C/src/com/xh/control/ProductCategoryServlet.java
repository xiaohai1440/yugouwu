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

import com.xh.bean.ProductCategory;
import com.xh.service.ProductCategoryService;
import com.xh.servicelmpl.ProductCategoryServiceImpl;

@WebServlet("/ProductCategoryServlet")
public class ProductCategoryServlet extends HttpServlet {
	
	
	ProductCategoryService p=new ProductCategoryServiceImpl();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String key=req.getParameter("methon");
		
		

		
		switch (key) {
		case "yiji":			
			getProductCategory(req,resp);						
			break;
			
			case "erji":
			
			getProductCategoryEj(req,resp);
						
			break;

		default:
			break;
		}
		
		
		
		
		
		
		
		
		
	}

	private void getProductCategoryEj(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		
		System.err.println("5555wang===="+req.getParameter("pageNum"));
		//上去实现就可以了
		//req.getParameter("pageNum")这个是1级菜单的主键
		List<ProductCategory> product = p.getProduct(req.getParameter("pageNum"));
		
		
		
		
		Gson gson = new Gson();
		//把数据转换为json格式
		String json = gson.toJson(product);
		// 获取输出流对象
		PrintWriter writer = resp.getWriter();
		// 返回数据给前台页面
		writer.print(json);      
		/*前台通过success : function(data) { 到数据[writer.print(json); 的json数据]
			var data = $.parseJSON(data);
		  }*/		
		//清空、关闭流
		writer.flush();
		writer.close();
		
		
		
		
		
		
	}

	private void getProductCategory(HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		
		List<ProductCategory> product = p.getProduct();
		
		
		
		
		
		System.err.println(product+"\n---------------------------------");
		
		Gson gson = new Gson();
		//把数据转换为json格式
		String json = gson.toJson(product);
		// 获取输出流对象
		PrintWriter writer = resp.getWriter();
		// 返回数据给前台页面
		writer.print(json);      
		/*前台通过success : function(data) { 到数据[writer.print(json); 的json数据]
			var data = $.parseJSON(data);
		  }		*/
		//清空、关闭流
		writer.flush();
		writer.close();
		
	}
	
	

}

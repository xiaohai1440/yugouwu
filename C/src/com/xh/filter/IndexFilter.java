package com.xh.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xh.bean.Product;
import com.xh.bean.ProductCategory;
import com.xh.control.ProductCategoryServlet;
import com.xh.service.ProductCategoryService;
import com.xh.servicelmpl.ProductCategoryServiceImpl;


@WebFilter("/*")
public class IndexFilter implements Filter {



	ProductCategoryServiceImpl p=new ProductCategoryServiceImpl();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//接口，子接口

		/*	HttpServletRequest  req= (HttpServletRequest)request;

		HttpServletResponse  resq= (HttpServletResponse)response;

		String path = req.getRequestURI();//获取的请求的uri

		System.err.println("===33"+(req.getParameter("list")));
		if(req.getParameter("list")!=null){

			arg2.doFilter(request, response);

		}else {

			resq.sendRedirect("ProductCategoryServlet?methon=yiji");

		}
		 */
		/*	System.err.println("666666666666666666666666");

		HttpServletRequest  req= (HttpServletRequest)request;
		 */
		//HttpServletResponse  resq= (HttpServletResponse)response;

		//String path = req.getRequestURI();//获取的请求的uri
		/*
		if (path.contains("inde")) {
			System.err.println("3333333333333336666666666");

		}*/



		//Map<ProductCategory, Map<ProductCategory, List<Product>>> product1 = p.getProduct1();

		//Map<ProductCategory, Map<ProductCategory, List<Product>>> product1 = p.getProduct1();


		System.err.println("============================================================3333333222222");


		//List<Map<ProductCategory, List<Product>>> listssEs=new ArrayList<>();

		HttpServletRequest  req= (HttpServletRequest)request;
		String path = req.getRequestURI();//获取的请求的uri
		System.err.println(path);
		//ProductCategoryServlet?methon=erji&id=674
		//	if (path.contains("/C/index.jsp")) {

		List<ProductCategory> product = p.getProduct();//1									
		List<List<ProductCategory>>  jihe2=new ArrayList<>();//2

		for (int i = 0; i <product.size(); i++) {

			List<ProductCategory> product2 = p.getProduct(product.get(i).getId());//2
			jihe2.add(product2);					

		}
		

		
		
		

		request.setAttribute("lists", product);									
		request.setAttribute("lists2", jihe2);

		//	}

		//methon

	/*	if (path.contains("/C/ProductCategoryServlet")
				&&"sanjiye".equals(req.getParameter("methon"))) {
			
			//List<Product> name = p.name(req.getParameter("methon"));
			
			
			//request.setAttribute("id", name);
			System.err.println("000000000000066666666666");

		}
*/
		



		arg2.doFilter(request, response);



	}




	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}



}

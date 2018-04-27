package com.xh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.xh.bean.User;



@WebFilter("/backstage/*")
public class LoginFilter implements Filter {

	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {
				
		
		//接口，子接口
		HttpServletRequest  req= (HttpServletRequest)request;
		
		HttpServletResponse  resq= (HttpServletResponse)response;
		
		String path = req.getRequestURI();
		
		//定位，url
		User user = (User) req.getSession().getAttribute("user"); // 看看session是否存有用户
		
		
		
	/*	System.err.println("000000000000000000");
		
		
		System.err.println("(user!=null&&user.getType()==1)= path.contains(.js)= (path.contains(.jsp)&&!path.contains(index.jsp))path.contains(.css)");
		
		System.err.println((user!=null&&user.getType()==1)+"="+ path.contains(".js")+"="+ (path.contains(".jsp")&&!path.contains("index.jsp"))+"="+ path.contains(".css"));
		*/
//		System.err.println("user!=null&&user.getType()==1");
//		System.err.println((user!=null)+"========="+user);
		
		/*|| path.contains(".js")|| (path.contains(".jsp")&&!path.contains("index.jsp"))|| path.contains(".css")*/
		if(user!=null&&user.getType()==1||path.contains("login.jsp")){//判断有没有登录成功！记得放行页面！
			
		
			filter.doFilter(request, response);
			
			
		}else {
			
			//在webroot   就可以直接拿到
			
			System.err.println("===================login.jsp");
			resq.sendRedirect("../login.jsp");
			
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("init>>>>>>>>>.启动");
		
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		System.out.println("destroy>>>>>>>>>销毁");
		
	}

}

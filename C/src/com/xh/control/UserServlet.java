package com.xh.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.xh.bean.User;
import com.xh.service.UserService;
import com.xh.servicelmpl.UserServiceImpl;
import com.xh.util.Md5Encrypt;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {


	private String show(String passward){



		String pwd="";
		try {
			pwd = Md5Encrypt.getEncryptedPwd(passward);//获得加密后的16进制
			byte[] bs = Md5Encrypt.hexStringToByte(pwd);//16进制的字符串转换成数组
			String q = Md5Encrypt.byteToHexString(bs);//baty数组转换成16进制字符串
			//    		System.out.println(q);
			/*	String pwds = Md5Encrypt.getEncryptedPwd("1235");//获得加密后的16进制
    		byte[] bss = Md5Encrypt.hexStringToByte(pwd);//16进制的字符串转换成数组
    		String qs = Md5Encrypt.byteToHexString(bs);//baey数组转换成16进制字符串
    		System.out.println(qs);	*/
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}//输入密码
		return pwd;
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String parameter = req.getParameter("method");


		switch (parameter) {

		case "add":

			UserService userService = new UserServiceImpl();		
			User user2 = new User();

			user2.setLoginName(req.getParameter("userName"));				
			user2.setPassword(show(req.getParameter("passWord")));	
			user2.setEmail(req.getParameter("email"));			
			user2.setMobile(req.getParameter("phone"));				
			userService.add(user2);

			resp.sendRedirect("login.jsp");		


			break;
		case "login":

			String user = req.getParameter("user");
			String pwd = req.getParameter("pwd");

			//pwd=show(pwd);


			UserService userService1 = new UserServiceImpl();			
			User login = userService1.loginPwd(user);	

			if (login.getPassword()!=null) {//判断用户的有没有								
				try {

					if (Md5Encrypt.validPassword(pwd, login.getPassword())||login.getPassword().equals(pwd)) {			
						String jizhu = req.getParameter("jizhu");			
						Cookie co=new Cookie("user",user);
						Cookie co1=new Cookie("pwd",login.getPassword());
						if(jizhu!=null){


							co.setMaxAge(60*60*24*14);
							co1.setMaxAge(60*60*24*14);
							resp.addCookie(co);
							resp.addCookie(co1);
							//resp.sendRedirect("showCookie75.jsp");	

						}else {

							co.setMaxAge(0);
							co1.setMaxAge(0);
							resp.addCookie(co);
							resp.addCookie(co1);

						}	

						req.getSession().setAttribute("user", login);
						
						if (login.getType()==0) {
							resp.sendRedirect("index.jsp");
						}else{
							
						    resp.sendRedirect("backstage/index.jsp");
						}

						

					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}


			}else {
				//	PrintWriter out = resp.getWriter();




				resp.sendRedirect("login.jsp");			

			}

			break;

		default:
			break;
		}


	}
}

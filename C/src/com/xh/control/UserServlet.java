package com.xh.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import com.xh.bean.Cart;
import com.xh.bean.CartItem;
import com.xh.bean.ShoppingCart;
import com.xh.bean.User;
import com.xh.service.ShoppingCartService;
import com.xh.service.UserService;
import com.xh.servicelmpl.ShoppingCartServiceImpl;
import com.xh.servicelmpl.UserServiceImpl;
import com.xh.util.Md5Encrypt;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	private static Logger logger=Logger.getLogger(UserServlet.class);
	
	UserService userService1 = new UserServiceImpl();	

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

	/*	req.setCharacterEncoding("UTF-8");*/

		String parameter = req.getParameter("method");

		switch (parameter) {
		
		case "uname":
			
			//这里是用户名查询是否相同

			String name = req.getParameter("username");
			
			User login1 = userService1.loginPwd(name);	
			
			
			//给ajax响应
			  if(login1!=null&&login1.getLoginName()!=null){
		            resp.getWriter().print(false);//返回数据到请求页面
		        }else{
		        	//resp.getWriter().write("用户主");//可以是html页面
		            resp.getWriter().print(true);
		        }


			
			break;

		case "add":

				
			User user2 = new User();
			user2.setLoginName(req.getParameter("userName"));				
			user2.setPassword(show(req.getParameter("passWord")));	
			user2.setEmail(req.getParameter("email"));			
			user2.setMobile(req.getParameter("phone"));	
			System.err.println("============================");
			if (userService1.add(user2)) {
				
				
									
				
				resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
                out.print("<script>");
                out.print("alert('用户添加成功!');");
                out.print("window.location.href='login.jsp'");
                out.print("</script>");
                out.flush();
                out.close();
//				resp.sendRedirect("login.jsp");	
                
                
				
			}else {
				
				
				resp.setContentType("text/html;charset=UTF-8");
                PrintWriter out = resp.getWriter();
                out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
                out.print("<script>");
                out.print("alert('用户添加成功!');");
                out.print("window.location.href='register.jsp'");
                out.print("</script>");
                out.flush();
                out.close();
				
				
				
				
				
			}

				


			break;
		case "login":

			String user = req.getParameter("user");
			String pwd = req.getParameter("pwd");

			//pwd=show(pwd);


					
			User login = userService1.loginPwd(user);	

			if (login!=null) {//判断用户的有没有		
				
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
						//
						req.getSession().setAttribute("user", login);
						
						System.err.println(login.getId()+"denglu=============");
						logger.debug("登录成功！");
						
						/*if (login.getType()==0) {
							//普通用户页面
							resp.sendRedirect("index.jsp");
							
						}else{
							//后台管理员登录页面
						    resp.sendRedirect("backstage/index.jsp");
						}
*/
						
						addCookieCart(req, login,resp);
						resp.sendRedirect("index.jsp");

					}else{
						
						logger.debug("登录失败！");
						
						
						resp.sendRedirect("login.jsp");			
						
					}
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}


			}else {
				//	PrintWriter out = resp.getWriter();
				logger.debug("登录失败！");
				resp.sendRedirect("login.jsp");			

			}

			break;

		default:
			break;
		}


	}
	
	
	private void addCookieCart(HttpServletRequest req, User user,HttpServletResponse resp) {
		System.out.println("进入===========》addCookieCart");
		Gson gson = new Gson();
		Cart carts1 = new Cart();
		
		List<CartItem> list4=new ArrayList<>();//存放购物车选项类
		
		
		Cookie[] cookies = req.getCookies();//从请求获取cookie
		for (Cookie cookie2 : cookies) {//循环cookie
			if(cookie2.getName().equals("cart")){//如果cookie有商品
				System.out.println("cookie2有值===========》");
				ShoppingCartService service=new ShoppingCartServiceImpl();
		    	
		    	List<ShoppingCart> list=service.select(user.getId());//根据用户从数据库查找购物车
		    	
		    	for (ShoppingCart shoppingCart : list) {
					System.err.println(shoppingCart+"777777777777777777733333333");
				}
		    	
		    	ShoppingCart cart=new ShoppingCart();//购物车类

				String value="";
				try {
					value = URLDecoder.decode(cookie2.getValue(),  
					           "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}//获取cookie的值
		    	carts1=	gson.fromJson(value, Cart.class);//将json数据反向生成对象
		    	Map<String, CartItem> map=carts1.getMap();
		    	for (Entry<String, CartItem> product : map.entrySet()) {//遍历Map
		    		System.out.println("遍历map=========>");
					CartItem cartItem = product.getValue();//根据key找到商品value
					System.out.println("cartItem========>"+cartItem);
					/*list4.add(cartItem);//把商品value存到list,每个商品唯一，因为map的key唯一*/					
					cart.setProductId(cartItem.getProduct().getId());
					cart.setProductNum(cartItem.getNum());
					cart.setUserId(user.getId());
					
			    	if(list.size()!=0){//用户ID的购物车下有商品
						System.out.println("用户登陆查看cookie=====2");
						boolean flag=false;
						for (ShoppingCart shoppingCart : list) {//遍历数据库购物车商品
							System.out.println(shoppingCart);
							System.out.println("用户登陆查看cookie=====3");
							if(shoppingCart.getProductId().intValue()==cart.getProductId().intValue()){//其中某个商品与要存进购物车的商品Id一致
								flag=true;
								System.out.println("shoppingCart=====>"+shoppingCart.getProductId());
								System.out.println("cart=====>"+cart.getProductId());
								System.out.println("用户登陆查看cookie=====4");
								cart.setProductNum(shoppingCart.getProductNum()+cart.getProductNum());//将要存进购物车的数量与之前的数量相加
								if(service.updata(cart)){//调用service层方法，不为0即存进成功
									System.out.println("成功加入购物车=====>updata");
									
								}else{
									System.out.println("加入购物车失败");
									
								}
								
							}//if(!flag)不能在这，因为遍历只要有一个不相等就是新增，
						}
						 if(!flag){//用户数据库存有商品，但没有cookie的商品
							 System.out.println("===========>没有cookie的商品");
							if(service.add(cart)){//调用service层方法，不为0即存进成功
								System.out.println("成功加入购物车=======>add");
							}else{
								System.out.println("加入购物车失败");
							}
							
						}
					}else{//用户ID的购物车下没有商品，直接存进数据库
						if(service.add(cart)){//调用service层方法，不为0即存进成功
							System.out.println("成功加入购物车");
						}else{
							System.out.println("加入购物车失败");
						}
						
					}

				}

			}
		}
		   if (cookies != null)  
	        {  
	            for (int i = 0; i < cookies.length; i++)  
	            {  
	                if (cookies[i].getName().equals("cart"))  
	                {  
	                	System.out.println("===========>遍历cookies");
	                    Cookie cookie = new Cookie("cart","");//这边得用"",不能用null  
	                    cookie.setPath("/");//设置成跟写入cookies一样的  
	                   // cookie.setDomain(".wangwz.com");//设置成跟写入cookies一样的  
	                    cookie.setMaxAge(0);  
	                    resp.addCookie(cookie);  
	                    System.out.println("清除完成");
	                }  
	            }  
	        }  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

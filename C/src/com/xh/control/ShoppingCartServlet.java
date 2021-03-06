package com.xh.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xh.bean.Cart;
import com.xh.bean.CartItem;
import com.xh.bean.Product;
import com.xh.bean.ShoppingCart;
import com.xh.bean.User;
import com.xh.service.ProductService;
import com.xh.service.ShoppingCartService;
import com.xh.servicelmpl.ProductServiceImpl;
import com.xh.servicelmpl.ShoppingCartServiceImpl;

@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet  extends HttpServlet{


	ShoppingCartService shopping=new ShoppingCartServiceImpl();
	ProductService product=new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("进入====================》ShoppingCartServlet");
		String page=req.getParameter("method");
		System.out.println(req.getParameter("method"));
		switch (page) {
		case "select":
			select(req, resp);
			break;
		case "finId":
			System.out.println("进入====================》finId");
			finById(req, resp);
			break;
		case "def":
			System.out.println("进入====================》def");
			getProduct(resp);
			break;
		case "addcar":
			System.out.println("进入====================》addcar");
			addcart(req, resp);
			break;	
		default:

			break;
		}
	}
	private void addcart(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		//json格式的工具类
		Gson gson = new Gson();
		//判断用户是否登录[取得session会话的user]
		User user=(User) req.getSession().getAttribute("user");		
		ShoppingCart cart=new ShoppingCart();//购物车类	

		if(user!=null){//判断是否用户时登陆添加购物车
			
			cart.setUserId(user.getId());//用户Id
			cart.setProductId(Integer.parseInt(req.getParameter("id")));//商品Id
			cart.setProductNum(Integer.parseInt(req.getParameter("num")));//数量

			boolean add=false;
			ShoppingCart select_Id = shopping.select_Id(cart);			
			if (null!=select_Id) {				
				cart.setProductNum(cart.getProductNum()+select_Id.getProductNum());				
				add = shopping.updata(cart);			
			}else {					
				add = shopping.add(cart);							
			}
		    //判断假如购物车是否成功！
			booleans(resp, add);			
		}else{
			//用户没有登录加购物车的情况
			cart(req, resp, gson);
						
		}
	}
	
	/**
	 * 
	 * @param req
	 * @param resp
	 * @param num
	 * @param gson
	 * @throws UnsupportedEncodingException
	 * @throws IOException       没有登录是添加购物车的2种情况！
	 */
	private void cart(HttpServletRequest req, HttpServletResponse resp,
			 Gson gson) throws UnsupportedEncodingException,
			IOException {
		int num=0;
		//如果用户没登录，分两种情况1：cookie已有购物车，2:cookie没有购物车，最后就是把商品存进cookie   
		Cart carts1 =null;
		//商品实体类---》取一次
		Product	product1=product.select_Id(req.getParameter("id"));
		//从请求中获取cookie[因为Cookie有很多个]
		Cookie[] cookies = req.getCookies();
		/** 
		Cookie的修改、删除
		Cookie并不提供修改、删除操作。如果要修改某个Cookie，只需要新建一个同名的Cookie，添加到response中覆盖原来的Cookie。
		如果要删除某个Cookie，只需要新建一个同名的Cookie，并将maxAge设置为0，并添加到response中覆盖原来的Cookie。
		注意：修改、删除Cookie时，新建的Cookie除value、maxAge之外的所有属性，例如name、path、domain等，都要与原Cookie完全一样。
		否则，浏览器将视为两个不同的Cookie不予覆盖，导致修改、删除失败。 
		*/
		boolean falg=false;//标记是否有购物车
		
		for(int i=0;i<cookies.length;i++){
			System.out.println("cookie长度========>"+(cookies.length+1));				
			if("cart".equals(cookies[i].getName())){//判断是否存在购物车的商品,还有其他方法吗？fei
				num=i;
				falg=true;					
				break;
			}

		}
		
		
		if (falg) {
			
			//如果cookie有购物车。那么就取出来，在添加商品在存进去！
			String value = URLDecoder.decode(cookies[num].getValue(), "UTF-8");			    	
			//将json[String]数据反向生成对象gson.fromJson()这是java代码获取json的方法、、$.parseJSON(data)这是前端				
			carts1=	gson.fromJson(value, Cart.class);			    	
			carts1.addProduct(product1, Integer.parseInt(req.getParameter("num")));//将商品存进cart类			    	
			//把json格式的数据存进cookie
			String json = gson.toJson(carts1); 
			System.out.println("json=========>select:"+json);	
			//cookie存中文的时候必须转码，不然中文乱码！
			Cookie cookie1=new Cookie("cart", URLEncoder.encode(json, "UTF-8"));
			cookie1.setPath("/");// 这个要设置 
			cookie1.setMaxAge(60 * 60);  
			//又存到cookie
			resp.addCookie(cookie1);

			
		}else {
			System.out.println("cookie不存在,那就创建cookie========>");
			//创建购物车
			Cart carts = new Cart();
			carts.addProduct(product1,Integer.parseInt(req.getParameter("num")));
			String json = gson.toJson(carts); //
			System.out.println("json=========>select:"+json);

			//把json格式的数据存进cookie
			Cookie cookie=new Cookie("cart", URLEncoder.encode(json, "UTF-8"));
			cookie.setPath("/");// 这个要设置 
			cookie.setMaxAge(60 * 60);  
			resp.addCookie(cookie);

		}
		
		
		booleans(resp, true);
		
		
		//	resp.sendRedirect("page.jsp?id="+req.getParameter("id"));
	}
	private void booleans(HttpServletResponse resp, boolean falg)
			throws IOException {
		if (falg) {

			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.print("<script>");
			out.print("alert('添加成功!');");
			// out.print("window.location.href='page.jsp'");
			out.print("</script>");
			out.flush();
			out.close();

		}else {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.print("<script>");
			out.print("alert('添加失败!');");
			// out.print("window.location.href='page.jsp'");
			out.print("</script>");
			out.flush();
			out.close();
		}
	}


	private void select(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		System.out.println("进入====================》select");
		User user1=(User) req.getSession().getAttribute("user");
		Gson gson = new Gson();
		if(user1!=null){//判断是否有用户登陆添加购物车
			System.out.println("用户已登陆========》");
			List<ShoppingCart> list2=shopping.select(user1.getId());//查找购物车，返回给前段购物车页面(包含商品Id,及数量，用户Id)
			Product product1=null;//商品实体类
			List<CartItem> list3=new ArrayList<>();//存放购物车选项类
			CartItem cartItem=null;
			for (int i = 0; i < list2.size(); i++) {//遍历某用户的购物车
				cartItem=new CartItem();
				product1=product.select_Id(list2.get(i).getProductId());//查找指定商品Id
				System.out.println("商品=====》"+product1);
				cartItem.setProduct(product1);//将值赋给购物车选项类
				System.out.println(cartItem.getProduct());
				cartItem.setNum(list2.get(i).getProductNum());
				System.out.println(cartItem.getNum());
				cartItem.setPrice(product1.getPrice());	
				System.out.println(cartItem.getPrice());
				list3.add(cartItem);//添加购物车选项类到集合中
			}
			String json = gson.toJson(list3); //用Json返回给前端
			System.out.println("json=========>select:"+json);
			PrintWriter writer = resp.getWriter();
			writer.print(json); // 返回数据给前台
			writer.close();
		}else{//用户没登陆，到cookie取值
			System.out.println("用户未登陆============>");
			Cookie[] cookies = req.getCookies();
			Cart carts1 = new Cart();
			List<CartItem> list4=new ArrayList<>();//存放购物车选项类
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("cart")){

					String value = URLDecoder.decode(cookies[i].getValue(), "UTF-8");//获取cookie的值
					carts1=	gson.fromJson(value, Cart.class);//将json数据反向生成对象
					Map<String, CartItem> map=carts1.getMap();
					for (Entry<String, CartItem> product : map.entrySet()) {
						CartItem cartItem = product.getValue();
						System.out.println("cartItem========>"+cartItem);
						list4.add(cartItem);
					}
				}
			}
			String json = gson.toJson(list4); //用Json返回给前端
			System.out.println("用户未登陆json=========>select:"+json);
			PrintWriter writer = resp.getWriter();
			writer.print(json); // 返回数据给前台
			writer.close();
		}
	}
	private void getProduct(HttpServletResponse resp) {
		
		
		
	}

	private void finById(HttpServletRequest req, HttpServletResponse resp) {

		List<ShoppingCart> list=shopping.select(req.getParameter("id"));

		Gson gson =new GsonBuilder() .create();

		String json = gson.toJson(list); 
		System.out.println(json);
		// 获取输出流对象
		PrintWriter writer;
		try {
			writer = resp.getWriter();
			writer.print(json); // 返回数据给前台
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

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
import com.xh.bean.Areas;
import com.xh.bean.Cities;
import com.xh.bean.Provinces;

import com.xh.service.ProductService;
import com.xh.service.ProvincesService;

import com.xh.servicelmpl.AreasServiceImpl;
import com.xh.servicelmpl.CitiesServiceImpl;
import com.xh.servicelmpl.ProvincesServiceImpl;


@WebServlet("/Ttt")
public class AddressServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
System.err.println("=====================>>>>>123");
		String key=req.getParameter("method");
		switch (key) {
		case "1":
			getProvinces(req,resp);
			break;
		case "2":
			getCities(req,resp);			
			break;
		case "3":
			getAreas(req,resp);
			break;

		default:
			break;
		}

	}

	private void getCities(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		
		CitiesServiceImpl cities = new CitiesServiceImpl();
		
		
		String parameter = req.getParameter("");
		List<Cities> select = cities.selectAllId("2");
		
		
		
		Gson gson =new GsonBuilder()
		.create();
		String json = gson.toJson(select); 
		System.out.println("json:"+json);
		PrintWriter writer = resp.getWriter();
		writer.print(json); // 返回数据给前台
		writer.close();
	
	}

	private void getAreas(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		
		AreasServiceImpl areas = new AreasServiceImpl();
		String parameter = req.getParameter("");
		List<Areas> select = areas.selectAllId(parameter);
		
		
		
		Gson gson =new GsonBuilder()
		.create();
		String json = gson.toJson(select); 
		System.out.println("json:"+json);
		PrintWriter writer = resp.getWriter();
		writer.print(json); // 返回数据给前台
		writer.close();
		
	}

	private void getProvinces(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		
		
		ProvincesService provinces=new ProvincesServiceImpl();
		
		String parameter = req.getParameter("");
		List<Provinces> select = provinces.select();
						
		Gson gson =new GsonBuilder()
		.create();
		String json = gson.toJson(select); 
		System.out.println("json:"+json);
		PrintWriter writer = resp.getWriter();
		writer.print(json); // 返回数据给前台
		writer.close();
					
	}
}

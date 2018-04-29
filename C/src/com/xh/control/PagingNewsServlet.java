package com.xh.control;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xh.bean.News;
import com.xh.service.NewsServiceDao;
import com.xh.servicelmpl.NewsServletlmpl;
import com.xh.util.PageInfo;

@WebServlet("/list")
public class PagingNewsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		*/
		System.err.println("进入test=================================");
		
		
	NewsServiceDao newsServletlmpl = new NewsServletlmpl();
	
	//获取到数据数据显示的页数下标
	PageInfo<News> news = newsServletlmpl.findAlls(Integer.parseInt(req.getParameter("pageNum")), 6);
	
	
	System.err.println("========"+newsServletlmpl.getTotalCount()+"======================");
	
	
	news.setPageNum(Integer.parseInt(req.getParameter("pageNum")));
	
	//总页面
	news.setTotal(newsServletlmpl.getTotalCount());
		
	
		
		
		System.out.println("总记录数===444444》" + news.getTotal());
		//谷歌的jar的类
		Gson gson = new Gson();
		//把数据转换为json格式
		String json = gson.toJson(news);
		
	
		// 获取输出流对象
		PrintWriter writer = resp.getWriter();
		writer.print(json); // 返回数据给前台页面
		
		System.err.println(json+"===========================================");
		writer.close();
		
		
	}

	
	
	
}

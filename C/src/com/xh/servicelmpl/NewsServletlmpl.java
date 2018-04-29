package com.xh.servicelmpl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.xh.bean.News;
import com.xh.dao.NewsDao;
import com.xh.dao.lmpl.NewsDaolmpl;
import com.xh.service.NewsServiceDao;
import com.xh.util.JdbcUtil;
import com.xh.util.PageInfo;
import com.xh.util.ResultSet_Util;





public class NewsServletlmpl implements NewsServiceDao {
	
	
	
	
	private static Logger logger=Logger.getLogger(NewsServletlmpl.class);
	
	NewsDao news=new NewsDaolmpl();
	

	@Override
	public boolean add(News t) {
		if (news.add(t)>0) {
			return  true;
		}
		return  false;
		
	
	}

	@Override
	public boolean delete(Serializable id) {
		
		
		int delete = news.delete(id);
		
		if (delete>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updata(News t) {
		
		
		int update = news.update(t);
		
		if (update>0) {
			
			return true;
			
		}
		
		
		return false;
	}

	@Override
	public List<News> select() {
		// TODO Auto-generated method stub
		
		
		
		return news.selectAll();
	}

	@Override
	public News select_Id(Serializable id) {
		
		
		
		return news.select_Id(id);
		
		
	}

	@Override
	public PageInfo<News> findAlls(int pageNum, int pageSize) {
		
		 PageInfo<News> pageInfo=new PageInfo<>();
		 
		 
		 //获取分页后的新闻记者集合，并赋值给 PageInfo<News>，对象  当前页pageNum，显示的条数pageSize
		 pageInfo.setList(news.findAlls(pageNum, pageSize));
		 
		// TODO Auto-generated method stub
		return pageInfo;
	}

	@Override
	public int getTotalCount() {
		
		
		return news.getTotalCount();
	}



}


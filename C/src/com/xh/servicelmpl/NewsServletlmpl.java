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
import com.xh.service.NewsServletDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;





public class NewsServletlmpl implements NewsServletDao {
	
	
	
	
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



}


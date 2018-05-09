package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.xh.bean.Browsing;
import com.xh.dao.BrowsingDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;

public class BrowsingDaoImpl extends JdbcUtil implements BrowsingDao {

	@Override
	public int add(Browsing t) {
		
		String sql="INSERT INTO browsing(`userid`,`productId`,`time`) VALUES(?,?,?)";
				
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Browsing t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Browsing> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Browsing select_Id(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Browsing> selectAllId(Serializable id) {
		// TODO Auto-generated method stub
		
		String sql="select * from browsing where userId=? ORDER BY time desc";
		List<Browsing> selectAllsa=null;
		try {
			result=exceuteQuery(sql, id);
			
		  selectAllsa = ResultSet_Util.selectAllsa(result, Browsing.class);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close_();
		}
		
		return selectAllsa;
	}

}

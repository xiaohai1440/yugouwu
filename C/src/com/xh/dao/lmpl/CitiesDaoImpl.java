package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xh.bean.Cities;
import com.xh.dao.CitiesDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;

public class CitiesDaoImpl extends JdbcUtil implements CitiesDao {

	@Override
	public int add(Cities t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Cities t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Cities> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cities select_Id(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cities> selectAllId(Serializable id) {
		// TODO Auto-generated method stub
		
		
		String sql="select * from cities where provinceid=?";
		List<Cities> selectAllsa=null;
		
		try {
			result = exceuteQuery(sql, id);
			
			selectAllsa = ResultSet_Util.selectAllsa(result, Cities.class);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close_();
		}
		
		
		
		
		
		
		return selectAllsa;
		
		
		
		
		
		
		
		
		
	}

}

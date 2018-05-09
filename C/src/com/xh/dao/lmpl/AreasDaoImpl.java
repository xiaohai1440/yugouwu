package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.xh.bean.Areas;
import com.xh.bean.Cities;
import com.xh.dao.AreasDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;

public class AreasDaoImpl extends JdbcUtil implements AreasDao {

	@Override
	public int add(Areas t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Areas t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Areas> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Areas select_Id(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Areas> selectAllId(Serializable id) {

		String sql="select * from areas where cityid=?";
		List<Areas> selectAllsa=null;
		
		try {
			result = exceuteQuery(sql, id);
			
			selectAllsa = ResultSet_Util.selectAllsa(result, Areas.class);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close_();
		}
		
	
		return selectAllsa;
		

		
		
	}

}

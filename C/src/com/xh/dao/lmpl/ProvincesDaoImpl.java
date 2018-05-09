package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.xh.bean.Areas;
import com.xh.bean.Provinces;
import com.xh.dao.ProvincesDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;

public class ProvincesDaoImpl extends JdbcUtil implements ProvincesDao {

	@Override
	public int add(Provinces t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Provinces t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Provinces> selectAll() {

		String sql="select * from Provinces";
		List<Provinces> selectAllsa=null;
		
		try {
			result = exceuteQuery(sql);
			
			selectAllsa = ResultSet_Util.selectAllsa(result, Provinces.class);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			close_();
		}
		
	
		return selectAllsa;
		

	}

	@Override
	public Provinces select_Id(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

}

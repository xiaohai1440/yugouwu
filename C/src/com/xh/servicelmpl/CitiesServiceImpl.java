package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Cities;
import com.xh.dao.lmpl.CitiesDaoImpl;
import com.xh.service.CitiesService;

public class CitiesServiceImpl implements CitiesService {

	@Override
	public boolean add(Cities t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updata(Cities t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cities> select() {
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
		
		CitiesDaoImpl citiesDaoImpl = new CitiesDaoImpl();
		
		
		
		return citiesDaoImpl.selectAllId(id);
	}

}

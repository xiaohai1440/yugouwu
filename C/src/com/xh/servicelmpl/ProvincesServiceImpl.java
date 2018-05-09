package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Product;
import com.xh.bean.Provinces;
import com.xh.dao.ProvincesDao;
import com.xh.dao.lmpl.ProvincesDaoImpl;
import com.xh.service.ProductService;
import com.xh.service.ProvincesService;

public class ProvincesServiceImpl implements ProvincesService {

	@Override
	public boolean add(Provinces t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updata(Provinces t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Provinces> select() {
		// TODO Auto-generated method stub
		ProvincesDao provincesDaoImpl = new ProvincesDaoImpl();
		
		return provincesDaoImpl.selectAll();
	}

	@Override
	public Provinces select_Id(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

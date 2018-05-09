package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Areas;
import com.xh.dao.lmpl.AreasDaoImpl;
import com.xh.service.AreasService;

public class AreasServiceImpl implements AreasService {

	@Override
	public boolean add(Areas t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updata(Areas t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Areas> select() {
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
		// TODO Auto-generated method stub
		
		
		AreasDaoImpl areas = new AreasDaoImpl();
		return areas.selectAllId(id);
	}

}

package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import net.spy.memcached.MemcachedClient;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xh.bean.Browsing;
import com.xh.dao.BrowsingDao;
import com.xh.dao.lmpl.BrowsingDaoImpl;
import com.xh.service.BrowsingService;
import com.xh.util.Memcached;

public class BrowsingServiceImpl implements BrowsingService {

	
	BrowsingDao browsingDao=new BrowsingDaoImpl();
 	
	@Override
	public boolean add(Browsing t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updata(Browsing t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Browsing> select() {
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
		
		MemcachedClient in = Memcached.getIn();
		List<Browsing> selectAllId=null;
		if (in.get(id+"liulanzuji")==null) {
			
			selectAllId= browsingDao.selectAllId(id);
			
			in.set(id+"liulanzuji", 60*30, selectAllId);
			
		}else {
			
			selectAllId= (List<Browsing>) in.get(id+"liulanzuji");
			
		}
		
	
		return selectAllId;
	}

}

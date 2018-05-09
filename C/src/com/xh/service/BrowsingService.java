package com.xh.service;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Browsing;

public interface BrowsingService extends BaseService<Browsing> {
	
	public List<Browsing> selectAllId(Serializable id);
	
}

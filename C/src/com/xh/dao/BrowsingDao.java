package com.xh.dao;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Browsing;

public interface BrowsingDao extends BaseDao<Browsing> {
	List<Browsing> selectAllId(Serializable id);	
	
}

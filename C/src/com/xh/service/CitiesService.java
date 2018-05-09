package com.xh.service;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Cities;

public interface CitiesService extends BaseService<Cities> {
	
	public List<Cities> selectAllId(Serializable id);
	
}
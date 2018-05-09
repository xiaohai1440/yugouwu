package com.xh.dao;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Cities;

public interface CitiesDao extends BaseDao<Cities> {
	List<Cities> selectAllId(Serializable id);
}

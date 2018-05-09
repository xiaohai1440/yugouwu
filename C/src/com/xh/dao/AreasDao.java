package com.xh.dao;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Areas;


public interface AreasDao extends BaseDao<Areas> {

	List<Areas> selectAllId(Serializable id);
}

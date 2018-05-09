package com.xh.service;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.Areas;

public interface AreasService extends BaseService<Areas>{
	
	List<Areas> selectAllId(Serializable id);

}

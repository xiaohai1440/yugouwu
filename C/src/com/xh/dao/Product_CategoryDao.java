package com.xh.dao;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.ProductCategory;


public interface Product_CategoryDao extends BaseDao<ProductCategory> {
	
	//取得3个表标题的----》在一节
	List<ProductCategory>  getProduct(); 
	List<ProductCategory>  getProduct(Serializable id); 
	
	

}

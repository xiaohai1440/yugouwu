package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xh.bean.ProductCategory;
import com.xh.dao.Product_CategoryDao;
import com.xh.dao.lmpl.Product_CategoryDaolmpl;
import com.xh.service.ProductCategoryService;


public class ProductCategoryServiceImpl implements ProductCategoryService {

	Product_CategoryDao pro=new Product_CategoryDaolmpl();

	@Override
	public boolean add(ProductCategory t) {
		// TODO Auto-generated method stub

		int add = pro.add(t);

		if (add>0) {
			System.err.println("新增成功！");
			return true;

		}else {
			System.err.println("新增失败！");
			return false;
		}
	

	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub

		int delete = pro.delete(id);
		if (delete>0) {
			System.err.println("删除成功！");
			return true;

		}else {
			System.err.println("删除失败！");
			return false;
		}
		

	}

	@Override
	public boolean updata(ProductCategory t) {
		// TODO Auto-generated method stub

		int update = pro.update(t);
		if (update>0) {
			System.err.println("更新成功！");
			return true;

		}else {
			System.err.println("更新失败！");
			return false;
		}
		

	}

	@Override
	public List<ProductCategory> select() {
		// TODO Auto-generated method stub
		List<ProductCategory> selectAll = pro.selectAll();

		return selectAll;

	}

	@Override
	public ProductCategory select_Id(Serializable id) {
		// TODO Auto-generated method stub

		ProductCategory select_Id = pro.select_Id(id);
		
		return select_Id;
	}

	@Override
	public List<ProductCategory> getProduct() {
		
		//1级标题，包括2,2包括3
		//Map<Object, Map<Object,Object>> hashMap = new LinkedHashMap<>();
		
		
		return pro.getProduct();
		
		
		
	}

	@Override
	public List<ProductCategory> getProduct(Serializable id) {
		// TODO Auto-generated method stub
		
		return  pro.getProduct(id);
		
		
	}

}

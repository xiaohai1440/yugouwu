package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.xh.bean.Product;
import com.xh.dao.ProductDao;
import com.xh.dao.lmpl.ProductDaolmpl;
import com.xh.service.ProductService;


public class ProductServiceImpl implements ProductService {

	private static Logger logger=Logger.getLogger(ProductServiceImpl.class);

	ProductDao productDao=new ProductDaolmpl();
	@Override
	public boolean add(Product t) {
		int add = productDao.add(t);

		if (add>0) {
			logger.debug("新增成功！");
			return true;


		}else {
			logger.debug("新增失败！");
			return false;

		}
		
	}

	@Override
	public boolean delete(Serializable id) {
		// TODO Auto-generated method stub
		int delete = productDao.delete(id);
		if (delete>0) {
			logger.debug("删除成功！");
			return true;

		}else {
			logger.debug("删除失败！");
			return false;

		}
		
	}

	@Override
	public boolean updata(Product t) {
		// TODO Auto-generated method stub
		int update = productDao.update(t);
		if (update>0) {
			logger.debug("更新成功！");
			return true;

		}else {
			logger.debug("更新失败！");
			return false;
		}
		


	}

	@Override
	public List<Product> select() {
		// TODO Auto-generated method stub
		List<Product> selectAll = productDao.selectAll();

		return selectAll;
	}

	@Override
	public Product select_Id(Serializable id) {
		// TODO Auto-generated method stub
		Product select_Id = productDao.select_Id(id);

		return select_Id;
	}

}

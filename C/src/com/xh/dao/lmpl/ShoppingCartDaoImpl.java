package com.xh.dao.lmpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.xh.bean.ShoppingCart;
import com.xh.dao.ShoppingCartDao;
import com.xh.util.JdbcUtil;
import com.xh.util.ResultSet_Util;



public class ShoppingCartDaoImpl extends JdbcUtil implements ShoppingCartDao{

	@Override
	public int add(ShoppingCart t) {
		String sql="insert into shopping_cart(userId,productId,productNum) values(?,?,?)";
		int result=0;
		Object[] objects={t.getUserId(),t.getProductId(),t.getProductNum()};
		result =this.exceuteUpdate(sql, objects);
		return result;
	}

	@Override
	public int delete(Serializable id) {
		String sql ="delete from shopping_cart where userId=?";
		int result=0;
		result=this.exceuteUpdate(sql, id);
		return result;
	}
	
	/**
	 * 有这个商品的是时候改
	 */

	@Override
	public int update(ShoppingCart t) {
		int result=0;
		//String sql="update shopping_cart set productId=?,productNum=? where userId=? and productId=?";
		String sql="update shopping_cart set productId=?,productNum=? where userId=? and productId=?";
		Object[] objects={t.getProductId(),t.getProductNum(),t.getUserId(),t.getProductId()};
		result=exceuteUpdate(sql,objects);
		return result;
	}
		
	@Override
	public List<ShoppingCart> selectAll() {
		return null;
	}
	
	@Override
	public ShoppingCart select_Id(Serializable id) {
		String sql="select * from shopping_cart where userId=? productId=?";
		ShoppingCart shoppingCart=null;
		try {
			result=exceuteQuery(sql);
			shoppingCart = ResultSet_Util.selectAlla(result, ShoppingCart.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close_();
		}
		return shoppingCart;
	}
	
	@Override
	public List<ShoppingCart> select(Serializable t) {
		
		String sql="select * from shopping_cart where userId=?";
		
		List<ShoppingCart> list =null;
		try {
			result=exceuteQuery(sql,t);
			
			list=ResultSet_Util.selectAllsa(result, ShoppingCart.class);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close_();
		}
		return list;
	}

	
	
	
	
/*	
	@Override
	public int delete(ShoppingCart id) {
		// TODO Auto-generated method stub
		return 0;
	}

	*//**
	 * 查看数据库内有没有数据
	 *//*
	@Override
	public int cha(ShoppingCart id) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	
}

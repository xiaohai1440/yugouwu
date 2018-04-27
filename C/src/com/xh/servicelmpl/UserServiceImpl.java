package com.xh.servicelmpl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.xh.bean.User;
import com.xh.dao.UserDao;
import com.xh.dao.lmpl.UserDaoImpl;
import com.xh.service.UserService;
import com.xh.util.Memcached;

import net.spy.memcached.MemcachedClient;


public class UserServiceImpl implements UserService{
	
	
	private static Logger logger=Logger.getLogger(UserServiceImpl.class);
	

	UserDao userDao=new UserDaoImpl();

	@Override
	public boolean add(User t) {
		// TODO Auto-generated method stub
		int add = userDao.add(t);
		
		

		if (add>0) {
			
			
			logger.debug("新增成功！");

		}else {
			
			logger.debug("新增失败！");
			
		}
		return false;




	}

	@Override
	public boolean delete(Serializable t) {
		// TODO Auto-generated method stub
		int delete = userDao.delete(t);
		if (delete>0) {
			System.err.println("更新成功！");

		}else {
			System.err.println("更新失败！");
		}
		return false;

	}

	@Override
	public boolean updata(User t) {
		// TODO Auto-generated method stub

		int update = userDao.update(t);
		if (update>0) {
			System.err.println("删除成功！");

		}else {
			System.err.println("删除失败！");
		}
		return false;


	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		List<User> selectAll = userDao.selectAll();



		return selectAll;
	}

	@Override
	public User select_Id(Serializable id) {
		// TODO Auto-generated method stub



		//	MemcachedClient in = Memcached.getIn();
		MemcachedClient in = Memcached.getIn();


		if (in.get("user")==null) {

			System.out.println("数据了拿数据！");
			User select_Id = userDao.select_Id(id);
			Memcached.getIn().set("user", 12, select_Id);
			return select_Id;

		}else {
			System.out.println("缓存拿的数据！");
			return (User)Memcached.getIn().get("user");
		}

	}

	@Override
	public User login(String userName, String passWord) {
		
		User login = userDao.login(userName, passWord);
		
		if (login.getLoginName()!=null) {
			
			logger.debug("登录 成功");
			return login;
		}else {
			logger.debug("登录失败！");
			return null;
		}
	
	}

	@Override
	public User loginPwd(String userName) {
		User login = userDao.loginPwd(userName);
		// TODO Auto-generated method stub
		return login;
	}




}

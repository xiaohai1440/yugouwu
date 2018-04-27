package com.xh.dao;

import com.xh.bean.User;


public interface UserDao extends BaseDao<User> {
	
	User login(String userName,String passWord);
	User loginPwd(String userName);
}

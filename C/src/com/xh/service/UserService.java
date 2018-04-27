package com.xh.service;

import java.io.Serializable;
import java.util.List;

import com.xh.bean.User;


public interface UserService extends BaseService<User> {
	
	
	User login(String userName,String passWord);
	User loginPwd(String userName);
	
	
	

}

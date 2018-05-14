package com.xh.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
		
	private static SqlSessionFactory factory;
		
	static{
		
		try {			
			//获取mybatis-config-xml的输入流配置文件
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			//创建SqlSessionFactory对象，完成对配置文件的读取
			factory=new SqlSessionFactoryBuilder().build(is);					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
	}
	
	/**
	 * 
	 * @return  创建SqlSession会话对象，完成一次和数据库的交互
	 */
	public static SqlSession createSqlSession(){
		
		//创建SqlSession会话
		return factory.openSession(false);//boolean 开启、关闭  事务
		
		
	}	
	
	/**
	 * 
	 * @param session 关闭流
	 * 
	 * 
	 */
	public static void closeSqlSession(SqlSession session){
		
		
		if (null!=session) {
			
			session.close();
			
			
			
		}
		
		
	}
}

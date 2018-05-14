package com.xh.test;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.xh.util.MybatisUtil;

public class UserMapperTest {
	
	private Logger logger = Logger.getLogger(UserMapperTest.class);
	
	
	@Test
	public void test() {
		
		
		//String resource = "mybatis-config.xml";
		System.err.println("444444");
		
		int count = 0;
		SqlSession createSqlSession = MybatisUtil.createSqlSession();
		System.err.println("444ssss444"+createSqlSession);
		try {
		/*SqlSession sqlSession = null;
	
			//1 获取mybatis-config.xml的输入流
			InputStream is = Resources.getResourceAsStream(resource);
			//2 创建SqlSessionFactory对象，完成对配置文件的读取
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3 创建sqlSession
			sqlSession = factory.openSession();*/
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			logger.debug("UserMapperTest count---> " + count);
			count = createSqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
			System.err.println("444455555555555");
			logger.debug("UserMapperTest count---> " + count);
			System.err.println("566666666666");
			System.err.println("444ssss444");
		}finally{
			createSqlSession.close();
		}
	}

}

package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.login.dao.UserDAO;

import cn.tedu.login.entity.User;
import cn.tedu.login.sevice.LoginService;

public class TestCast {
private UserDAO dao;
@Before
public void init(){

	ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mvc.xml");
	dao=ac.getBean(UserDAO.class);
}
@Test  //测试数据访问层
public void test2() {
	   User user =dao.findByUsername("King");
//		System.out.println(dao.findAll());
	   System.out.println(user);
}
@Test  //测试业务层
public void test3() {
	  ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mvc.xml");
	 LoginService ls=ac.getBean("loginService",LoginService.class);
	 User user=ls.checkLogin("King", "123");
	 System.out.println(user);
}
}

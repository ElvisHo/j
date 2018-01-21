package cn.tedu.login.sevice;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import cn.tedu.login.dao.UserDAO;
import cn.tedu.login.entity.User;
/**
 * 业务层实现类
 * @author Administrator
 *注：业务层应该使用@Service 开始组件扫描
 */
@Service("loginService")
public class LoginServiceIpml implements LoginService{
    @Resource(name="userDAO")
	private UserDAO dao; 
	public User checkLogin(String uname, String pwd) {
		User user=null;
		user=dao.findByUsername(uname);
		if(user==null){
			/*
			 * 抛出应用异常
			 * 应用异常，指的是用户的错误操作引起的异常，
			 * 比如用户名填写错误。这样的异常发生之后，应该给
			 * 用户明确的提示
			 */
			throw new AppException("用户名错误");
		}
		if(!user.getPwd().equals(pwd)){
			throw new AppException("密码错误");
		}
		return user;
	}

}

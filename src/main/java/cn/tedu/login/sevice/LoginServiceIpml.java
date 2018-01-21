package cn.tedu.login.sevice;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import cn.tedu.login.dao.UserDAO;
import cn.tedu.login.entity.User;
/**
 * ҵ���ʵ����
 * @author Administrator
 *ע��ҵ���Ӧ��ʹ��@Service ��ʼ���ɨ��
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
			 * �׳�Ӧ���쳣
			 * Ӧ���쳣��ָ�����û��Ĵ������������쳣��
			 * �����û�����д�����������쳣����֮��Ӧ�ø�
			 * �û���ȷ����ʾ
			 */
			throw new AppException("�û�������");
		}
		if(!user.getPwd().equals(pwd)){
			throw new AppException("�������");
		}
		return user;
	}

}

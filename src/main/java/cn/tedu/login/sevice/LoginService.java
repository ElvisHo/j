package cn.tedu.login.sevice;

import cn.tedu.login.entity.User;

/**
 * ҵ���ӿ�
 * @author Administrator
 *
 */
public interface LoginService {
   public User checkLogin(String uname,String pwd);
}

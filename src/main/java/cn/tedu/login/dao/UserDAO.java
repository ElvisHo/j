package cn.tedu.login.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.login.entity.User;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
@Repository("userDAO")
public interface UserDAO {
    public User findByUsername(String username);
    List<User> findAll();
    
}

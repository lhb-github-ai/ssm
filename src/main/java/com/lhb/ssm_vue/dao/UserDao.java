package com.lhb.ssm_vue.dao;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.ssm_vue.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public int saveUser(User user);

    public List<User> findAll();

    public User findOne(String username);

    public int update(User user);

    public int delete(Integer id);

}

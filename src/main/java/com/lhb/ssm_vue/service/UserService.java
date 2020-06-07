package com.lhb.ssm_vue.service;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.ssm_vue.entity.User;

import java.util.List;

public interface UserService {

    public int saveUser(User user);

    public List<User> findAll();

    public User findOne(String username);

    public int update(User user);

    public int delete(Integer id);

}

package com.lhb.service;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.entity.User;

import java.util.List;

public interface UserService {

    public int saveUser(User user);

    public List<User> findAll();

    public User findOne(String username);

    public int update(User user);

    public int delete(Integer id);

    public int check(String username,String password);

    public User check1(String username,String password);


}

package com.lhb.ssm_vue.service.impl;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.ssm_vue.dao.UserDao;
import com.lhb.ssm_vue.entity.User;
import com.lhb.ssm_vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UseServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(String username) {
        return userDao.findOne(username);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }
}

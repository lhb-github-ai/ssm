package com.lhb.service.impl;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.dao.UserDao;
import com.lhb.entity.User;
import com.lhb.service.UserService;
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
        user.setRole("老师");
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

    @Override
    public int check(String username, String password) {
        User check = userDao.check(username, password);
        if (check!=null){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public User check1(String username, String password) {
        return userDao.check(username,password);
    }
}

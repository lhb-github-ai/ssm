package com.lhb.dao;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    public int saveUser(User user);

    public List<User> findAll();

    public User findOne(String username);

    public int update(User user);

    public int delete(Integer id);

    public User check(@Param("username") String username,@Param("password") String password);

}

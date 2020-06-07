package com.lhb.ssm_vue.dao;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.ssm_vue.entity.College;
import com.lhb.ssm_vue.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeDao {
    public int save(College college);

    public List<College> findAll();

    public College findOne(String name);

    public int update(College college);

    public int delete(Integer id);
}

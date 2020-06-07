package com.lhb.ssm_vue.service;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.ssm_vue.entity.College;
import com.lhb.ssm_vue.entity.User;

import java.util.List;

public interface CollegeService {

    public int save(College college);

    public List<College> findAll();

    public College findOne(String name);

    public int update(College college);

    public int delete(Integer id);

}

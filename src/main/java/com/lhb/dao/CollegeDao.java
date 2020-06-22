package com.lhb.dao;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.entity.College;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeDao {
    public int save(College college);

    public List<College> findAll();

    public College findOne(String name);

    public College findById(Integer id);

    public int update(College college);

    public int delete(Integer id);
}

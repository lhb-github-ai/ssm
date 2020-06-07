package com.lhb.ssm_vue.dao;/*
 *@Author lee
 * @date 2020/06/07
 */

import com.lhb.ssm_vue.entity.Student;
import com.lhb.ssm_vue.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    public int save(Student student);

    public List<Student> findAll();

    public Student findOne(String studentName);

    public int update(Student student);

    public int delete(Integer id);
}

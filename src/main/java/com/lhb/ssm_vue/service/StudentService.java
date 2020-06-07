package com.lhb.ssm_vue.service;/*
 *@Author lee
 * @date 2020/06/07
 */

import com.lhb.ssm_vue.entity.Student;

import java.util.List;

public interface StudentService {

    public int save(Student student);

    public List<Student> findAll();

    public Student findOne(String studentName);

    public int update(Student student);

    public int delete(Integer id);
}

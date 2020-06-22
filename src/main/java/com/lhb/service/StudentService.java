package com.lhb.service;/*
 *@Author lee
 * @date 2020/06/07
 */

import com.lhb.entity.Student;

import java.util.List;

public interface StudentService {

    public int save(Student student);

    public List<Student> findAll();

    public Student findOne(String studentName);

    public List<Student>  findOne2(String studentName);

    public int update(Student student);

    public int delete(Integer id);

    public Student check1(String studentName,String password);

    public int check(String studentName,String password);
}

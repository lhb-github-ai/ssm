package com.lhb.dao;/*
 *@Author lee
 * @date 2020/06/07
 */

import com.lhb.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    public int save(Student student);

    public List<Student> findAll();

    public Student findOne(String studentName);

    public List<Student>  findOne2(String studentName);

    public int update(Student student);

    public int delete(Integer id);

    public Student check(@Param("studentName") String studentName, @Param("password") String password);
}

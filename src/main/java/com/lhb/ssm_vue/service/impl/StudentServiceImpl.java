package com.lhb.ssm_vue.service.impl;/*
 *@Author lee
 * @date 2020/06/07
 */

import com.lhb.ssm_vue.dao.StudentDao;
import com.lhb.ssm_vue.entity.Student;
import com.lhb.ssm_vue.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findOne(String studentName) {
        return studentDao.findOne(studentName);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }
}

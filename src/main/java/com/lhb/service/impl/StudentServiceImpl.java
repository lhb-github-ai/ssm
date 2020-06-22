package com.lhb.service.impl;/*
 *@Author lee
 * @date 2020/06/07
 */

import com.lhb.dao.ClazzDao;
import com.lhb.dao.StudentDao;
import com.lhb.dao.CollegeDao;
import com.lhb.entity.Student;
import com.lhb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClazzDao clazzDao;
    @Autowired
    private CollegeDao collegeDao;

    @Override
    public int save(Student student) {
        student.setRole("学生");
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
    public List<Student> findOne2(String studentName) {
        return studentDao.findOne2(studentName);
    }

    @Override
    public int update(Student student)
    {
        student.setClazzId(clazzDao.findOne(student.getClazzName()).getId());
        student.setGradeId(collegeDao.findOne(student.getGradeName()).getId());
        return studentDao.update(student);
    }

    @Override
    public int delete(Integer id) {
        return studentDao.delete(id);
    }

    @Override
    public Student check1(String studentName, String password) {
        return studentDao.check(studentName,password);
    }

    @Override
    public int check(String studentName, String password) {
        Student check = studentDao.check(studentName, password);
        if (check!=null){
            return 1;
        }else {
            return 0;
        }

    }
}

package com.lhb.service.impl;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.dao.ClazzDao;
import com.lhb.dao.CollegeDao;
import com.lhb.entity.Clazz;
import com.lhb.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzDao clazzDao;
    @Autowired
    private CollegeDao collegeDao;

    @Override
    public int save(Clazz clazz) {
        return clazzDao.save(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzDao.findAll();
    }

    @Override
    public Clazz findOne(String name) {
        return clazzDao.findOne(name);
    }

    @Override
    public List<Clazz> findAllClazz(Integer gradeId) {
        return clazzDao.findAllClazz(gradeId);
    }

    @Override
    public int update(Clazz clazz) {
            clazz.setGradeId(collegeDao.findOne(clazz.getGradeName()).getId());
        return clazzDao.update(clazz);
    }

    @Override
    public int delete(Integer id) {
        return clazzDao.delete(id);

    }
}

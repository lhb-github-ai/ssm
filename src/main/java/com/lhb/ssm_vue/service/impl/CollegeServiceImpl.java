package com.lhb.ssm_vue.service.impl;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.ssm_vue.dao.CollegeDao;
import com.lhb.ssm_vue.entity.College;
import com.lhb.ssm_vue.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeDao collegeDao;

    @Override
    public int save(College college) {
        return collegeDao.save(college);
    }

    @Override
    public List<College> findAll() {
        return collegeDao.findAll();
    }

    @Override
    public College findOne(String name) {
        return collegeDao.findOne(name);
    }

    @Override
    public int update(College college) {
        return collegeDao.update(college);
    }

    @Override
    public int delete(Integer id) {
        return collegeDao.delete(id);
    }
}

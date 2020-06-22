package com.lhb.service;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.lhb.entity.Clazz;

import java.util.List;

public interface ClazzService {

    public int save(Clazz clazz);

    public List<Clazz> findAll();

    public Clazz findOne(String name);

    public List<Clazz> findAllClazz(Integer gradeId);

    public int update(Clazz clazz);

    public int delete(Integer id);

}

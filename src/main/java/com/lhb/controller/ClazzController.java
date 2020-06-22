package com.lhb.controller;/*
 *@Author lee
 * @date 2020/06/06
 */


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.entity.Clazz;
import com.lhb.entity.College;
import com.lhb.service.ClazzService;
import com.lhb.service.CollegeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//允许跨域
@RequestMapping("/clazz")
@Slf4j
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    @Autowired
    private CollegeService collegeService;

    @GetMapping("/findAll")
    public PageInfo findAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Clazz> clazzes = clazzService.findAll();
        PageInfo pageInfo = new PageInfo(clazzes);
        return pageInfo;
    }
    @PostMapping("/save")
    public Map<String, String> save(@RequestBody Clazz clazz){
        HashMap<String, String> map = new HashMap<>();
        Clazz one = clazzService.findOne(clazz.getName());
        if (one!=null){
            map.put("type", "error");
            map.put("msg", "该用户已经存在");
        }else
        {
            clazzService.save(clazz);
            map.put("type", "success");
            map.put("msg", "添加成功");
        }

        return map;
    }
    @PostMapping("/update")
    public Map<String, String> update(@RequestBody Clazz clazz){
        HashMap<String, String> map = new HashMap<>();
        log.info(String.valueOf(clazz));
//        System.out.println(user);
        clazzService.update(clazz);
        map.put("type", "success");
        map.put("msg", "修改成功");
        return map;
    }
    @PostMapping("/delete")
    public Map<String, String> delete(Integer id){
        HashMap<String, String> map = new HashMap<>();
        int i = clazzService.delete(id);
        if(i>0){
            map.put("type", "success");
            map.put("msg", "删除成功");
        }
        else {
            map.put("type", "error");
            map.put("msg", "删除失败");
        }
        return map;
    }

    @GetMapping("/findAllClazz")
    public HashMap<String, Object> findAllClazz(Integer gradeId){

        HashMap<String, Object> map = new HashMap<>();
        List<Clazz> clazzes = clazzService.findAllClazz(gradeId);
        map.put("clazzes", clazzes);
        return map;
    }

    @GetMapping("/findAllClazzName")
    public HashMap<String, Object> findAllClazzName(String name){
        College one1 = collegeService.findOne(name);
        HashMap<String, Object> map = new HashMap<>();
        List<Clazz> clazzes = clazzService.findAllClazz(Math.toIntExact(one1.getId()));
        map.put("clazzes", clazzes);
        return map;
    }
}

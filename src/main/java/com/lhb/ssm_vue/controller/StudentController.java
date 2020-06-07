package com.lhb.ssm_vue.controller;/*
 *@Author lee
 * @date 2020/06/07
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.ssm_vue.entity.Student;
import com.lhb.ssm_vue.entity.User;
import com.lhb.ssm_vue.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//允许跨域
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public PageInfo findAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Student> users = studentService.findAll();
        PageInfo pageInfo = new PageInfo(users,5);
        return pageInfo;
    }

    @PostMapping("/save")
    public Map<String, String> save(@RequestBody Student student){
        HashMap<String, String> map = new HashMap<>();
        Student one = studentService.findOne(student.getStudentName());
        log.info(String.valueOf(student));
//        System.out.println(user);
        if (one!=null){
            map.put("type", "error");
            map.put("msg", "该学生已经存在");
        }else
        {
            studentService.save(student);
            map.put("type", "success");
            map.put("msg", "添加成功");
        }
        return map;
    }
    @PostMapping("/update")
    public Map<String, String> update(@RequestBody Student student){
        HashMap<String, String> map = new HashMap<>();
        studentService.update(student);
        map.put("type", "success");
        map.put("msg", "修改成功");
        return map;
    }
    @PostMapping("/delete")
    public Map<String, String> delete(Integer id){
        HashMap<String, String> map = new HashMap<>();
        int i = studentService.delete(id);
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
}

package com.lhb.controller;/*
 *@Author lee
 * @date 2020/06/07
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.entity.Student;
import com.lhb.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

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
        System.out.println(student);
        studentService.update(student);
        map.put("type", "success");
//        map.put("msg", "修改成功");
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

    @PostMapping("/fileUpload")
    public Map<String, String> fileUpload( @RequestParam("photo") List<MultipartFile>  uploadfile){
        HashMap<String, String> map = new HashMap<>();
        if (!uploadfile.isEmpty() && uploadfile.size()>0){

            for (MultipartFile  file:uploadfile){
                String  originalFilename=file.getOriginalFilename();
                String filePath = "D:\\AAA\\学生管理系统SSM --vue\\ssm_vue1\\src\\assets\\images\\";
                String newFilename= UUID.randomUUID()+originalFilename;
                try {
                    file.transferTo(new File(filePath + newFilename));
                    System.out.println(filePath+newFilename);
                    map.put("src",filePath+newFilename);
                } catch (Exception e) {
                    e.printStackTrace();
                    map.put("error","上传失败");
                    return map;
                }
            }
            map.put("success","上传成功");
            return map;
        }else {
            map.put("error","上传失败");
            return map;
        }

    }

    @PostMapping("/check")
    public Map<String, Object> check(@RequestBody Student student){
        int check = studentService.check(student.getUsername(), student.getPassword());
        Student student1 = studentService.check1(student.getUsername(), student.getPassword());
        HashMap<String, Object> map = new HashMap<>();
        log.info(String.valueOf(check));
        if (check>0){
            map.put("user",student1);
            map.put("success","success");
            return map;
        }
        map.put("fail","fail");
        return map;
    }

    @PostMapping("/findOne")
    public  Map<String, Object> findOne( String  studentName){
        List<Student> one = studentService.findOne2(studentName);
        HashMap<String, Object> map = new HashMap<>();
        map.put("student",one);
        return map;
    }
}

package com.lhb.controller;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.service.CollegeService;
import com.lhb.entity.College;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//允许跨域
@RequestMapping("/college")
@Slf4j
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping("/findAll")
    public PageInfo findAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<College> colleges = collegeService.findAll();
        PageInfo<College> pageInfo = new PageInfo<>(colleges);
        return pageInfo;
    }
    @PostMapping("/save")
    public Map<String, String> save(@RequestBody College college){
        HashMap<String, String> map = new HashMap<>();
        College one = collegeService.findOne(college.getName());
        if (one!=null){
            map.put("type", "error");
            map.put("msg", "该用户已经存在");
        }else
        {
            collegeService.save(college);
            map.put("type", "success");
            map.put("msg", "添加成功");
        }

        return map;
    }
    @PostMapping("/update")
    public Map<String, String> update(@RequestBody College college){
        HashMap<String, String> map = new HashMap<>();
        log.info(String.valueOf(college));
//        System.out.println(user);
        collegeService.update(college);
        map.put("type", "success");
        map.put("msg", "修改成功");
        return map;
    }
    @PostMapping("/delete")
    public Map<String, String> delete(Integer id){
        HashMap<String, String> map = new HashMap<>();
        int i = collegeService.delete(id);
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

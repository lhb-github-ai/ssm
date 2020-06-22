package com.lhb.controller;/*
 *@Author lee
 * @date 2020/06/06
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhb.entity.Student;
import com.lhb.entity.User;
import com.lhb.service.StudentService;
import com.lhb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//允许跨域
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public PageInfo findAll(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,@RequestParam(value = "pageSize", defaultValue = "4") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userService.findAll();
        PageInfo pageInfo = new PageInfo(users,5);
        return pageInfo;
    }
    @PostMapping("/save")
    public Map<String, String> save(@RequestBody User user){
        HashMap<String, String> map = new HashMap<>();
        User one = userService.findOne(user.getUsername());
        log.info(String.valueOf(user));
//        System.out.println(user);
        if (one!=null){
            map.put("type", "error");
            map.put("msg", "该用户已经存在");
        }else
        {
            userService.saveUser(user);
            map.put("type", "success");
            map.put("msg", "添加成功");
        }

        return map;
    }
    @PostMapping("/update")
    public Map<String, String> update(@RequestBody User user){
        HashMap<String, String> map = new HashMap<>();
        log.info(String.valueOf(user));
//        System.out.println(user);
            userService.update(user);
            map.put("type", "success");
            map.put("msg", "修改成功");
        return map;
    }
    @PostMapping("/delete")
    public Map<String, String> delete(Integer id){
        HashMap<String, String> map = new HashMap<>();
        int i = userService.delete(id);
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
    @PostMapping("/check")
    public Map<String, Object> check(@RequestBody User user, HttpSession session){

//System.out.println(user);

        int check = userService.check(user.getUsername(), user.getPassword());
        User user1 = userService.check1(user.getUsername(), user.getPassword());


        int check2 = studentService.check(user.getUsername(), user.getPassword());
        Student student1 = studentService.check1(user.getUsername(), user.getPassword());
        HashMap<String, Object> map = new HashMap<>();
        log.info(String.valueOf(check));
        if (check>0){
            map.put("user",user1);
            session.setAttribute("user" ,user1);
            map.put("success","success");
            User user2 = (User) session.getAttribute("user");
            System.out.println(user2+"222");
            return map;
        }
        else if (check2>0){
            map.put("user",student1);
            session.setAttribute("user" ,student1);

            map.put("success","success");
        }
        map.put("fail","fail");
        return map;

    }
}

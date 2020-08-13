package com.chen.controller;

import com.chen.bean.PageBean;
import com.chen.pojo.Student;
import com.chen.pojo.Students;
import com.chen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("getUser")
    public Map<String,Object> getUser(){

        List<Student> studentList = studentService.getUser();
        Map<String,Object> map = new HashMap<>();

        map.put("data",studentList);
        return map;
    }

    @RequestMapping("getUserByPage")
    public Map<String,Object> getUserByPage(@RequestBody PageBean pageBean){

        List<Students> studentList = studentService.getUserByPage(pageBean);
        Map<String,Object> map = new HashMap<>();

        map.put("data",studentList);
        return map;
    }

    @GetMapping("test")
    public Map<String,Object> test(){
        Map<String ,Object> map = new HashMap<>();
        map.put("1","你");
        map.put("2","好");
        map.put("3","呀");
        map.put("4","！");
        map.put("5","我");
        map.put("6","是");
        map.put("7","神");
        return map;
    }
}

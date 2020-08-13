package com.chen.service;

import com.chen.bean.PageBean;
import com.chen.pojo.Student;
import com.chen.pojo.Students;

import java.util.List;

public interface StudentService {

    List<Student> getUser();

    List<Students> getUserByPage(PageBean pageBean);

}

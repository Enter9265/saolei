package com.chen.service.impl;

import com.chen.bean.PageBean;
import com.chen.dao.StudentDao;
import com.chen.pojo.Student;
import com.chen.pojo.Students;
import com.chen.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getUser() {

        List<Student> studentList = studentDao.selectAll();

        return studentList;
    }

    @Override
    public List<Students> getUserByPage(PageBean pageBean) {

        Integer pageSize = pageBean.getPageSize();
        Integer currentPage = pageBean.getCurrentPage();

        pageBean.setCurrentPage((currentPage-1)*pageSize);
        List<Students> list = studentDao.getUserByPage(pageBean);
        return list;
    }
}

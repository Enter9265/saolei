package com.chen.dao;

import com.chen.bean.PageBean;
import com.chen.pojo.Student;
import com.chen.pojo.Students;
import org.springframework.stereotype.Controller;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//extends Mapper<Student>
@Controller
public interface StudentDao {

    List<Student> selectAll();

    List<Students> getUserByPage(PageBean pageBean);

}

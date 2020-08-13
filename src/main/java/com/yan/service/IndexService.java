package com.yan.service;


import com.yan.dao.Generate;
import com.yan.pojo.Index;
import com.yan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public interface IndexService {


    /**
     * 获取雷的位置
     * @param user
     * @return
     */
    User getIndex(User user);


    User select(User user,int x,int y);

}

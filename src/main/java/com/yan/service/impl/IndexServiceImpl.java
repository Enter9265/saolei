package com.yan.service.impl;


import com.yan.dao.Generate;
import com.yan.pojo.User;
import com.yan.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private Generate generate;
    /**
     * 获取雷的位置
     * @param user
     * @return
     */
    public User getIndex(User user){
        int[][] method = generate.method(user.getNumber(), user.getX(), user.getY());

        user.setMap(method);

        return user;
    }


    public User select(User user,int x,int y) {

        return generate.gets(user,x,y);
    }



    public static void main(String[] args) {
        Set<String> linkedList = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            boolean add = linkedList.add("111");

            System.out.println(add);
        }

        for (String s : linkedList) {
            System.out.println(s);
        }
    }
}

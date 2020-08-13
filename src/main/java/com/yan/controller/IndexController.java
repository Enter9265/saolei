package com.yan.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.pojo.Result;
import com.yan.pojo.User;
import com.yan.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sweep")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取数据雷
     *
     * @param user
     * @return
     */
    @RequestMapping("/doGet")
    public Result doGet(User user, HttpServletResponse response, HttpServletRequest request) {
        ObjectMapper objectMapper = new ObjectMapper();
        Cookie[] cookies = request.getCookies();
        String str = null;
        if (cookies != null) {//用户是否登录过
            int x = user.getX();
            int y = user.getY();

            try {

                for (Cookie cookie : cookies) {
                    if ("UUid".equals(cookie.getName())) {

                        str = cookie.getValue();
                        if (x == 0 && y == 0) {//获取用户是否有未结束的游戏
                            //                        User user1 = maps.get(str);
                            User user1 = (User) redisTemplate.boundValueOps(str).get();
//                            String user2 = (String) redisTemplate.boundValueOps(str).get();
//                            User user1 = objectMapper.readValue(user2, User.class);
                            if (user1 != null) {
                                return new Result(true, "获取成功", user1);
                            } else {
                                return new Result(false, "获取失败", user1);
                            }
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            str = UUID.randomUUID().toString().replace("-", "");
        }


        user = indexService.getIndex(user);//获取
        Cookie cookie = new Cookie("UUid", str);
        cookie.setMaxAge(604800);
        response.addCookie(cookie);
        int x1 = user.getX();
        int y1 = user.getY();
        user.setSurplus(x1 * y1);
        String s = null;
        try {
            s = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
//        redisTemplate.boundValueOps(str).set(s);
        redisTemplate.boundValueOps(str).set(user);
        return new Result(true, "获取成功", user);
    }

    /**
     * 获取数据雷
     *
     * @param x,y
     * @return
     */
    @RequestMapping("/select")
    public Result select(int x, int y, HttpServletRequest request) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Cookie[] cookies = request.getCookies();
            String str = null;

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("UUid".equals(cookie.getName())) {
                        str = cookie.getValue();
                    }
                }
            }
//        User user = maps.get(str);
            User user = (User) redisTemplate.boundValueOps(str).get();
//            String user2 = (String) redisTemplate.boundValueOps(str).get();
//            User user = objectMapper.readValue(user2, User.class);

            User user1 = indexService.select(user, x, y);
            int size = user1.getSet().size();

            int x1 = user.getX();
            int y1 = user.getY();

            user1.setSurplus(x1 * y1 - size);
            int stepSize = user1.getStepSize() + 1;
            user1.setStepSize(stepSize);

//        if (user1.)

//            String s = objectMapper.writeValueAsString(user1);
//            redisTemplate.boundValueOps(str).set(s);
            redisTemplate.boundValueOps(str).set(user1);

            return new Result(true, "获取成功", user1);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "系统出错");
        }
    }

    /**
     * 获取数据雷
     *
     * @param x,y
     * @return
     */
    @RequestMapping("/insert")
    public Result insert(int x, int y, String str) {

//        Cookie[] cookies = request.getCookies();
//        String str = null;
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("UUid".equals(cookie.getName())) {
//                    str = cookie.getValue();
//                }
//            }
//        }

        redisTemplate.boundValueOps(str).set("你好呀");

//        Object o = redisTemplate.boundValueOps(str).get();
//        List values = redisTemplate.boundHashOps(str).values();

        return new Result(true, "获取成功", "1");
    }

    /**
     * 获取数据雷
     *
     * @param
     * @return
     */
    @RequestMapping("/get")
    public Result get(String str) {

//        Cookie[] cookies = request.getCookies();
//        String str = null;
//
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("UUid".equals(cookie.getName())) {
//                    str = cookie.getValue();
//                }
//            }
//        }

//        redisTemplate.boundValueOps(str).set("你好呀");
        String o = (String) redisTemplate.boundValueOps(str).get();

//        Object o = redisTemplate.boundValueOps(str).get();
//        List values = redisTemplate.boundHashOps(str).values();

        return new Result(true, "获取成功", o);
    }

}

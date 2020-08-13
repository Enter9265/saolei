package com.chen.demo;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {


    @RequestMapping("test01")
    public String show() {
        RedisTemplate redisTemplate = new RedisTemplate();
        return "你好";
    }
}

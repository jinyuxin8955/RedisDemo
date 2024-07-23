package com.example.redisdemo.controller;

import com.example.redisdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/redis")
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "get")
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @RequestMapping(value = "set")
    public boolean set(String key, String value) {
        return redisUtil.set(key, value);
    }

}

package com.example.redisdemo.controller;

import com.example.redisdemo.entity.Stu;
import com.example.redisdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/setList")
    public boolean setList() {
        List<Object> stuList = new ArrayList<>();
        Stu stu1 = new Stu(1, "Lily", 18, "Software");
        Stu stu2 = new Stu(2, "Pete", 20, "Hardware");
        Stu stu3 = new Stu(3, "Paul", 24, "Engineer");

        stuList.add(stu1);
        stuList.add(stu2);
        stuList.add(stu3);

        return redisUtil.lSetList("stu", stuList);
    }

    @RequestMapping(value = "/getList")
    public Object getList() {
        return redisUtil.lGet("stu", 0, -1);
    }

    @GetMapping("/printHello")
    @ResponseBody
    public Object printHello() {
        return "Hello, World!";
    }

}

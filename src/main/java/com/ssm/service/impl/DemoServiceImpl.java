package com.ssm.service.impl;

import com.ssm.mapper.UserMapper;
import com.ssm.pojo.User;
import com.ssm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String doAny() {
        System.out.println("DemoServiceImpl doAny");

        List<User> users = userMapper.listUser();
        System.out.println(users);

        return "doAny ok";
    }
}

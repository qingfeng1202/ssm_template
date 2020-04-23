package com.ssm.service.impl;

import com.ssm.service.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String doAny() {
        System.out.println("DemoServiceImpl doAny");
        return "doAny ok";
    }
}

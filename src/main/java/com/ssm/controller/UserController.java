package com.ssm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("")
public class UserController {

    @RequestMapping("/demo")
    public String demo(){
        return "userController";
    }

}

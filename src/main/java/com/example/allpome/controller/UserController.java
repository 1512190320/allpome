package com.example.allpome.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.example.allpome.entity.UserInfo;
import  com.example.allpome.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private  UserService userService;

    @RequestMapping(value = "/get_user_info", method = RequestMethod.GET)
    public UserInfo get_user_info(@RequestParam String user_ID){
        System.out.println(user_ID);
        if(userService.GetUserInfo(user_ID) != null)
            return userService.GetUserInfo(user_ID);
        else
            return null;

    }
}

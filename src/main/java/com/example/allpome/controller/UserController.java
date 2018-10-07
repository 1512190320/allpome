package com.example.allpome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.allpome.entity.UserInfo;
import  com.example.allpome.service.UserService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private  UserService userService;

    @RequestMapping(value = "/get_user_info", method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam String user_ID){
        //System.out.println(user_ID);
        /**
            ATTENETIO!!!!
         */
        if(userService.GetUserInfo(user_ID) != null)
            return userService.GetUserInfo(user_ID);
        else
            return null;

    }
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public void addUser(@RequestParam String user_ID,@RequestParam String pass_wd) {
        // 添加用户
        //String sql = "insert into t_user(username, password) values(?, ?)";
        System.out.println("do add");
        userService.AddUser(user_ID,pass_wd);
    }
    @RequestMapping(value = "/delete_user",method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam String user_ID,@RequestParam String pass_wd){
        UserInfo userInfo = userService.GetUserInfo(user_ID);
        System.out.println("try delete");
        if(userInfo.getPassWord().equals(pass_wd)){
            System.out.println("do delete");
            userService.DeleteUser(user_ID);
        }

        else {
            /*
            DO SOMETHING!!
             */
        }
    }
    @RequestMapping(value = "/change_password", method = RequestMethod.POST)
    public void changePasswd(@RequestParam String user_ID,@RequestParam String pass_wd_old,@RequestParam String pass_wd_new){
        UserInfo userInfo = userService.GetUserInfo(user_ID);
        System.out.println("try change");
        if(userInfo.getPassWord().equals(pass_wd_old)){
            System.out.println("do change");
            userService.UpdateUser(user_ID,pass_wd_new);
        }

        else {
            /*
            DO SOMETHING!!
             */
        }
    }

}

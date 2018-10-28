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
    public UserInfo getUserInfo(@RequestParam String user_ID) throws Exception{
        //System.out.println(user_ID);

        try{
            return userService.GetUserInfo(user_ID);
        }catch (Exception e){

        }
        return null;
    }
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public Integer addUser(@RequestParam String user_ID,@RequestParam String pass_wd) throws Exception {
        // 添加用户
        try{
            UserInfo userInfo = userService.GetUserInfo(user_ID);
        }catch (Exception e){
            return userService.AddUser(user_ID,pass_wd);
        }
        return -1;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public boolean login(@RequestParam String user_ID,@RequestParam String pass_wd) throws Exception{
        try {
            userService.CheckUser(user_ID,pass_wd);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}

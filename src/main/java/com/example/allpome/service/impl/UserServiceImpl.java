package com.example.allpome.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.example.allpome.entity.UserInfo;
import com.example.allpome.service.UserService;

import java.util.Map;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  implements  UserService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserInfo GetUserInfo(String userID){
        Map<String,Object> map=jdbcTemplate.queryForMap("select * from user_info where user_ID = ?",userID);

        if(null!=map && map.size()>0) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserID(map.get("user_ID").toString());
            userInfo.setPassWord(map.get("pass_word").toString());
            userInfo.setUserFan((Integer) map.get("user_fan"));
            userInfo.setUserFollow((Integer) map.get("user_follow"));
            //userInfoList.add(userInfo);
            return userInfo;
        }
        return null;
    }

    @Override
    public Integer AddUser(String userID, String passWd){
        String sql = "insert into user_info(user_ID, pass_word) values(?, ?)";
        return jdbcTemplate.update(sql, userID, passWd);
    }
    @Override
    public void DeleteUser(String userID){
        String sql = "DELETE FROM user_info WHERE user_ID = ?";
        jdbcTemplate.update(sql, userID);
    }
    @Override
    public void UpdateUser(String userID, String passWd){
        String sql = "UPDATE user_info SET pass_word = ? WHERE user_ID = ?";
        jdbcTemplate.update(sql, passWd, userID);
    }
}

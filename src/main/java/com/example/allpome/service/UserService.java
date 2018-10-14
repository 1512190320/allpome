package com.example.allpome.service;
import com.example.allpome.entity.UserInfo;

public interface UserService {
    /**
     * 获取用户信息
     *
     * @param userID
     * @return UserInfo
     */
    UserInfo GetUserInfo(String userID);

    /**
     *
     * @param userID
     * @param passWd
     * @return
     */
    Integer AddUser(String userID, String passWd);

    /**
     *删除用户
     * @param userID
     */
    void DeleteUser(String userID);

    /**
     * 修改密码
     * @param userID
     * @param passWd
     */
    void UpdateUser(String userID, String passWd);
}

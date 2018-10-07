package com.example.allpome.service;
import com.example.allpome.entity.PoemInfo;

public interface PoemService {
    /**
     * 获取诗词信息
     * @param Mode PoemID
     * @return PoemInfo
     */
    PoemInfo GetPoemInfo(String Mode ,String PoemID);

    /**
     * 点赞诗词
     * @param PoemID
     * @param UserID
     * @return
     */
    void LikePoem(String PoemID, String UserID);

    /**
     * 收藏诗词
     * @param PoemID
     * @param UserID
     */
    void StarPoem(String PoemID, String UserID);
}

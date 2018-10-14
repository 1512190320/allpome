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
     * 收藏诗词
     * @param PoemID
     * @param UserID
     */
    Boolean StarPoem(String PoemID, String UserID) throws Exception;

    /**
     *
     * @param PoemID
     * @param UserID
     * @return
     */
    Boolean StarPoemCancel(String PoemID, String UserID) throws Exception;

    /**
     *
     * @param PoemID
     * @param UserID
     * @return
     * @throws Exception
     */
    Boolean LikePoem(String PoemID, String UserID) throws Exception;

    /**
     *
     * @param PoemID
     * @param UserID
     * @return
     * @throws Exception
     */
    Boolean LikePoemCancel(String PoemID, String UserID)throws Exception;
}

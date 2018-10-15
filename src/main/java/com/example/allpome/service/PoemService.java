package com.example.allpome.service;
import com.example.allpome.entity.PoemInfo;

import java.util.List;

public interface PoemService {
    /**
     * 获取一首诗词信息
     * @param PoemID
     * @return PoemInfo
     */
    PoemInfo GetPoemInfo(String PoemID);

    /**
     *
     * @param video_num
     * @param Mode
     * @param Value
     * @return
     */
    List<PoemInfo> GetPoems(Integer video_num, String Mode, String Value);
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

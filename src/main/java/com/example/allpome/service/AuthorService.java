package com.example.allpome.service;

import com.example.allpome.entity.AuthorInfo;

import java.util.List;

public interface AuthorService {
    /**
     *
     * @param AuthorID
     * @return
     */
    AuthorInfo GetAuthorInfo(String AuthorID);

    /**
     *
     * @param AuthorName
     * @return
     */
    List<AuthorInfo> GetAuthorByName(String AuthorName);
}

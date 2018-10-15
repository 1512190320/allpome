package com.example.allpome.service.impl;

import com.example.allpome.entity.AuthorInfo;
import com.example.allpome.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private AuthorInfo setAuthorInfo(Map<String,Object> map){
        AuthorInfo authorInfo = new AuthorInfo();
        authorInfo.setAuthorID(map.get("author_ID").toString());
        authorInfo.setAuthorIntroduce(map.get("author_introduce").toString());
        authorInfo.setAuthorName(map.get("author_name").toString());

        return authorInfo;
    }

    @Override
    public AuthorInfo GetAuthorInfo(String AuthorID){
        String sql = "select * from author_table where author_ID = ?";
        Map<String,Object> map=jdbcTemplate.queryForMap(sql,AuthorID);
//        Map<String,Object> map=jdbcTemplate.queryForMap("select * from poem_table where ? = ?",Mode,Value);

        if(null!=map && map.size()>0) {
            AuthorInfo poemInfo = setAuthorInfo(map);
            return poemInfo;
        }
        return null;
    }
    @Override
    public List<AuthorInfo>GetAuthorByName(String Name){
        String tmp = "select * from author_table where author_name like ?";
        List<AuthorInfo> returnList = new ArrayList<>();
        Name = "%" + Name + "%";
        List<Map<String,Object>> objList = jdbcTemplate.queryForList(tmp,Name);

        for(Map<String,Object> map : objList){
            AuthorInfo authorInfo = setAuthorInfo(map);
            returnList.add(authorInfo);
        }
        return returnList;
    }
}

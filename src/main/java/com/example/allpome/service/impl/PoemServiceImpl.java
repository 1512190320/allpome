package com.example.allpome.service.impl;

import com.example.allpome.entity.PoemInfo;
import com.example.allpome.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import java.nio.charset.Charset;
@Service
public class PoemServiceImpl implements PoemService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public PoemInfo GetPoemInfo(String Mode ,String Value){

        String tmp = "select * from poem_table where " + Mode + "= \"" + Value +"\"";
        System.out.println(tmp);
/*
Value 是UTF8
 */
        Map<String,Object> map=jdbcTemplate.queryForMap(tmp);
//        Map<String,Object> map=jdbcTemplate.queryForMap("select * from poem_table where ? = ?",Mode,Value);

        if(null!=map && map.size()>0) {
            System.out.println("run2");
            PoemInfo poemInfo = new PoemInfo();
            poemInfo.setPoemID(map.get("poem_ID").toString());
//            poemInfo.setPoemTitle(map.get("poem_title").toString());
//            poemInfo.setPoemContent(map.get("poem_content").toString());
//            poemInfo.setPoemNote(map.get("poem_note").toString());
//            poemInfo.setPoemTranslation(map.get("poem_translation").toString());
//
//            poemInfo.setPoemLike((Integer) map.get("poem_like"));
//            poemInfo.setPoemStar((Integer) map.get("poem_star"));
//            poemInfo.setPoemCommentNum((Integer)map.get("poem_comment_num"));
//
//            poemInfo.setOri((Integer) map.get("is_ori"));
//            poemInfo.setPoemHoliday(map.get("poem_holiday").toString());
//            poemInfo.setPoemSolarTerms(map.get("poem_solar_terms").toString());
//            poemInfo.setPoemStatement(map.get("poem_statement").toString());
//
//            poemInfo.setAuthor_ID(map.get("author_ID").toString());
//            poemInfo.setUserID(map.get("user_ID").toString());
//            poemInfo.setVisible((Integer)map.get("is_visible"));
//
//            poemInfo.setWritingDate((Date) map.get("writing_date"));
//            poemInfo.setEditDate((Date) map.get("edit_date"));

            System.out.println("run3");
            System.out.println(poemInfo);
            return poemInfo;
        }
        System.out.println("run no");
        return null;
    }

    @Override
    public void LikePoem(String PoemID, String UserID){

    }


    @Override
    public void StarPoem(String PoemID, String UserID) {

    }
}

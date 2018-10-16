package com.example.allpome.service.impl;

import com.example.allpome.entity.PoemInfo;
import com.example.allpome.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import java.nio.charset.Charset;
@Service
public class PoemServiceImpl implements PoemService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private PoemInfo setPoemInfo(Map<String,Object> map){
        PoemInfo poemInfo = new PoemInfo();
        poemInfo.setPoemID(map.get("poem_ID").toString());
        poemInfo.setPoemTitle(map.get("poem_title").toString());
        poemInfo.setPoemContent(map.get("poem_content").toString());

        if (null != map.get("poem_note"))
            poemInfo.setPoemNote(map.get("poem_note").toString());
        if (null != map.get("poem_translation"))
            poemInfo.setPoemTranslation(map.get("poem_translation").toString());

        poemInfo.setPoemLike((Integer) map.get("poem_like"));
        poemInfo.setPoemStar((Integer) map.get("poem_star"));
        poemInfo.setPoemCommentNum((Integer)map.get("poem_comment_num"));

        if (null != map.get("poem_holiday"))
            poemInfo.setPoemHoliday(map.get("poem_holiday").toString());
        if (null != map.get("poem_solar_terms"))
            poemInfo.setPoemSolarTerms(map.get("poem_solar_terms").toString());
        if (null != map.get("poem_statement"))
            poemInfo.setPoemStatement(map.get("poem_statement").toString());

        poemInfo.setIsOri((Integer) map.get("is_ori"));
        if ((Integer) map.get("is_ori") == 0){
                /*
                古诗
                 */
            poemInfo.setAuthor_ID(map.get("author_ID").toString());
        }
        else{
                /*
                原创诗词
                 */
            poemInfo.setUserID(map.get("user_ID").toString());
            poemInfo.setIsVisible((Integer)map.get("is_visible"));
            poemInfo.setWritingDate((Date) map.get("writing_date"));
            poemInfo.setEditDate((Date) map.get("edit_date"));
        }
        return poemInfo;
    }

    @Override
    public PoemInfo GetPoemInfo(String PoemID){

        String tmp = "select * from poem_table where poem_ID = ?";
        System.out.println(tmp);
        Map<String,Object> map=jdbcTemplate.queryForMap(tmp,PoemID);
//        Map<String,Object> map=jdbcTemplate.queryForMap("select * from poem_table where ? = ?",Mode,Value);

        if(null!=map && map.size()>0) {
            PoemInfo poemInfo = setPoemInfo(map);
            return poemInfo;
        }
        return null;
    }

    @Override
    public List<PoemInfo> GetPoems(Integer poem_num, String Mode, String Value, String isOri){
        String tmp = "select * from poem_table where " + Mode + " like ? and id_ori = ?";
        System.out.println(tmp);
        List<PoemInfo> returnList = new ArrayList<>();
        Value = "%" + Value + "%";
        List<Map<String,Object>> objList = jdbcTemplate.queryForList(tmp,Value,isOri);

        for(Map<String,Object> map : objList){
            PoemInfo poemInfo = setPoemInfo(map);
            returnList.add(poemInfo);
        }
        return returnList;
    }


    @Override
    public Boolean LikePoem(String PoemID, String UserID) throws Exception{
        try{
            Map<String,Object> map = jdbcTemplate.queryForMap( "select * from user_like_conn where poem_ID = ? AND user_ID = ?",PoemID,UserID);
            System.out.println("have like already");

        }catch(Exception e){
            System.out.println("no like now");
            // 点赞数增加
            String sql = "update poem_table set poem_like = poem_like + 1 where poem_ID = ?";
            jdbcTemplate.update(sql,PoemID);
            //  在连接表中加入条目
            sql = "insert into user_like_conn (poem_ID, user_ID) values(?,?)";
            jdbcTemplate.update(sql,PoemID,UserID);
            return true;
        }
        return false;
    }

    @Override
    public Boolean LikePoemCancel(String PoemID, String UserID) throws Exception{
        try{
            Map<String,Object> map = jdbcTemplate.queryForMap( "select * from user_like_conn where poem_ID = ? AND user_ID = ?",PoemID,UserID);
            if(null != map){
                String sql = "update poem_table set poem_like = poem_like - 1 where poem_ID = ?";
                jdbcTemplate.update(sql,PoemID);
                //  在连接表中加入条目
                sql = "delete from user_like_conn where poem_ID = ? AND user_ID = ?";
                jdbcTemplate.update(sql,PoemID,UserID);
            }

        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Boolean StarPoem(String PoemID, String UserID) throws Exception{
        try{
            Map<String,Object> map = jdbcTemplate.queryForMap( "select * from user_star_conn where poem_ID = ? AND user_ID = ?",PoemID,UserID);
            System.out.println("have star already");

        }catch(Exception e){
            // 收藏数增加
            String sql = "update poem_table set poem_star = poem_star + 1 where poem_ID = ?";
            jdbcTemplate.update(sql,PoemID);
            //  在连接表中加入条目
            sql = "insert into user_star_conn (poem_ID, user_ID) values(?,?)";
            jdbcTemplate.update(sql,PoemID,UserID);
            return true;
        }
        return false;
    }
    @Override
    public Boolean StarPoemCancel(String PoemID, String UserID) throws Exception{
        try{
            Map<String,Object> map = jdbcTemplate.queryForMap( "select * from user_star_conn where poem_ID = ? AND user_ID = ?",PoemID,UserID);
            if(null != map){
                String sql = "update poem_table set poem_star = poem_star - 1 where poem_ID = ?";
                jdbcTemplate.update(sql,PoemID);
                //  在连接表中加入条目
                sql = "delete from user_star_conn where poem_ID = ? AND user_ID = ?";
                jdbcTemplate.update(sql,PoemID,UserID);
            }

        }catch (Exception e){
            return false;
        }
        return true;
    }
}

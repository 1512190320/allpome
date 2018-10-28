package com.example.allpome.controller;
import com.example.allpome.entity.AuthorInfo;
import com.example.allpome.entity.PoemInfo;
import com.example.allpome.service.AuthorService;
import com.example.allpome.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class PoemController {
    @Autowired
    private PoemService poemService;
    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/get_poem_info_by_id", method = RequestMethod.GET)
    public PoemInfo GetPoemInfoByID(@RequestParam String poem_ID) throws Exception{
        try{
            return poemService.GetPoemInfo(poem_ID);
        }catch (Exception e){

        }
        return null;
    }

    @RequestMapping(value = "/get_poem_info_by_key", method = RequestMethod.GET)
    public List<PoemInfo> GetPoemInfoByIDKey(@RequestParam String key, @RequestParam String value){
        Set<String> searchKeys = new HashSet<>();
        Integer listNum = 10;
        searchKeys.add("poem_holiday");
        searchKeys.add("poem_solar_terms");
        searchKeys.add("poem_statement");
        searchKeys.add("poem_season");
        searchKeys.add("author_ID");
        searchKeys.add("poem_title");

        if (searchKeys.contains(key)){
            System.out.println("33333333333");
            return poemService.GetPoems(listNum,key,value,"0");
        }
        else {
            return null;
        }
    }

    @RequestMapping(value = "/get_ori_poem_info_by_key", method = RequestMethod.GET)
    public List<PoemInfo> GetOriPoemInfoByIDKey(@RequestParam String key, @RequestParam String value){
        Set<String> searchKeys = new HashSet<>();
        Integer listNum = 10;
        searchKeys.add("poem_holiday");
        searchKeys.add("poem_solar_terms");
        searchKeys.add("poem_statement");
        searchKeys.add("poem_season");

        if (searchKeys.contains(key)){
            return poemService.GetPoems(listNum,key,value,"1");
        }
        else {
            return null;
        }
    }

    @RequestMapping(value = "/like_poem", method = RequestMethod.POST)
    public String LikePoem(@RequestParam String PoemID, @RequestParam String UserID)throws Exception{
        if(poemService.LikePoem(PoemID, UserID)){
            return UserID + " like " + " poemID:  " + PoemID;
        }
        else{
            poemService.LikePoemCancel(PoemID, UserID);
            return UserID + " cancel like " + " poemID:  " + PoemID;
        }
    }
    @RequestMapping(value = "/star_poem", method = RequestMethod.POST)
    public String StarPoem(@RequestParam String PoemID, @RequestParam String UserID)throws Exception{
        if(poemService.StarPoem(PoemID, UserID)){
            return UserID + " star " + " poemID:  " + PoemID;
        }
        else{
            poemService.StarPoemCancel(PoemID, UserID);
            return UserID + " star " + " poemID:  " + PoemID;
        }
    }
    @RequestMapping(value = "/get_rec_poem_by_knv", method = RequestMethod.GET)
    public List<PoemInfo> GetRecPoem(@RequestParam String RecKey,@RequestParam String RecValue){
        int length_of_l = 10;
        List<PoemInfo> RecPoemList = poemService.GetRecPoem(length_of_l,RecKey,RecValue);

        return RecPoemList;
    }
    @RequestMapping(value = "/get_poem_by_author_name", method = RequestMethod.GET)
    public List<PoemInfo> GetPoemByAName(@RequestParam String AuthorName){
        Integer listNum = 10;
        List<AuthorInfo> AuthorList = authorService.GetAuthorByName(AuthorName);
        System.out.println(AuthorList);
        System.out.println("11111111111111111111");
        List<PoemInfo> PoemList = new ArrayList<>();
        for (AuthorInfo author : AuthorList){
            List<PoemInfo> tmpList = poemService.GetPoems(listNum,"author_ID",author.getAuthorID(),"0");
            System.out.println(tmpList);
            System.out.println("222222222222222222");
            for (PoemInfo tmp : tmpList){
                PoemList.add(tmp);
            }
        }
        return PoemList;
    }
}

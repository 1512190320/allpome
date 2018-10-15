package com.example.allpome.controller;
import com.example.allpome.entity.PoemInfo;
import com.example.allpome.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class PoemController {
    @Autowired
    private PoemService poemService;

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

        if (searchKeys.contains(key)){
            return poemService.GetPoems(listNum,key,value);
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
}

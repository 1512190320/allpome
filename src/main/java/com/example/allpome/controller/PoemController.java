package com.example.allpome.controller;
import com.example.allpome.entity.PoemInfo;
import com.example.allpome.service.PoemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PoemController {
    @Autowired
    private PoemService poemService;

    @RequestMapping(value = "/get_poem_info_by_Title", method = RequestMethod.GET)
    public PoemInfo GetPoemInfoByIDTitle(@RequestParam String title){
        //title = "\"" + title + "\"";
        System.out.println(title);
        return poemService.GetPoemInfo("poem_title",title);
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

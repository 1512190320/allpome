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
}

package com.example.allpome.controller;

import com.example.allpome.entity.AuthorInfo;
import com.example.allpome.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/get_author_by_name", method = RequestMethod.GET)
    public List<AuthorInfo> GetAuthorByName(@RequestParam String name){
        if (name.equals("")){
            return null;
        }
        else{
            return authorService.GetAuthorByName(name);
        }
    }
    @RequestMapping(value = "/get_author_by_id", method = RequestMethod.GET)
    public AuthorInfo GetAuthorByID(@RequestParam String author_ID){
        if (author_ID.equals("")){
            return null;
        }
        else{
            return authorService.GetAuthorInfo(author_ID);
        }
    }
}

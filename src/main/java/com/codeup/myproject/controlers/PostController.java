package com.codeup.myproject.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts(){
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsId(@PathVariable String id){
        return "posts postswith this "+ id;
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreate(){
        return "Create posts";
    }

    @PostMapping("/posts")
    @ResponseBody
    public String save(){
        return "post req handling";
    }
}

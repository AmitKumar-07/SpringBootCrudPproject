package com.first.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/test")
    @ResponseBody
    public String handleTest() {

        return "hello world";
    }

    @RequestMapping("/about")
    public String about(){
        return "about";
    }

}

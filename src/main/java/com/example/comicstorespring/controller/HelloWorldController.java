package com.example.comicstorespring.controller;

import com.example.comicstorespring.model.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class HelloWorldController {

    //https://spring.io/guides/tutorials/bookmarks/

    @GetMapping("/hello-world-bean")
    public HelloWorldBean getHelloWorldBean(){
        System.out.println("getHelloWorldBean---");
        return new HelloWorldBean("Hi there A");
    }


}

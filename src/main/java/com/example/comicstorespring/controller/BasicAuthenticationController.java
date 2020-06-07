package com.example.comicstorespring.controller;

import com.example.comicstorespring.model.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin
@RestController
public class BasicAuthenticationController {

    //https://spring.io/guides/tutorials/bookmarks/

    @GetMapping("/basicauth")
    public AuthenticationBean getAuthenticationBean(){
        System.out.println("AuthenticationBean---");
        return new AuthenticationBean("Hello, welcome") {
        };
    }


}

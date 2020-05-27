package com.example.comicstorespring.controller;


import com.example.comicstorespring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TodoResource {

    @Autowired
    private TodoService todoService;


    // http://localhost:8080/users/in28minutes/todos
    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username){
        System.out.println("userName---"+username);
        return todoService.findAll();
    }

}

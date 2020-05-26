package com.example.comicstorespring.controller;

import com.example.comicstorespring.model.Todo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todoList = new ArrayList<>();
    private static int idCounter = 0;

    static{
        todoList.add(new Todo(1, "in28Mins", "Learn Spring", new Date(), false));
        todoList.add(new Todo(2, "in28Mins", "Learn Miscroservices", new Date(), false));
        todoList.add(new Todo(3, "in28Mins", "Learn Angiler", new Date(), false));
        todoList.add(new Todo(4, "in28Mins", "Learn to dix my car", new Date(), false));
        todoList.add(new Todo(5, "in28Mins", "Learn surfing", new Date(), false));
        todoList.add(new Todo(6, "in28Mins", "Earn money", new Date(), false));
        todoList.add(new Todo(7, "in28Mins", "Earn money 1", new Date(), false));
        todoList.add(new Todo(8, "in28Mins", "Earn money 2", new Date(), false));
        todoList.add(new Todo(9, "in28Mins", "Earn money 3", new Date(), false));
        todoList.add(new Todo(10, "in28Mins", "Earn money 4", new Date(), false));
        todoList.add(new Todo(11, "in28Mins", "Earn money 5", new Date(), false));
        todoList.add(new Todo(12, "in28Mins", "Earn money 6", new Date(), false));
        todoList.add(new Todo(13, "in28Mins", "Earn money 7", new Date(), false));
    }


    public List<Todo> findAll(){
        return todoList;
    }

}

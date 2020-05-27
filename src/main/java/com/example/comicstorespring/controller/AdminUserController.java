package com.example.comicstorespring.controller;


import com.example.comicstorespring.dao.AdminUserRepository;
import com.example.comicstorespring.dao.AdminUserRepositoryImpl;
import com.example.comicstorespring.model.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//@CrossOrigin
@RestController
public class AdminUserController {

    private final AdminUserRepository adminUserRepository;

    AdminUserController(AdminUserRepository repository) {
        this.adminUserRepository = repository;
    }

    @GetMapping("/adminUsers")
    ResponseEntity<List<AdminUser>> all(@RequestParam(name="limit",required = false, defaultValue = "3") Integer limit,
                                        @RequestParam(name="offset", required = false, defaultValue = "2") Integer offset) {

        System.out.println("\n");
        System.out.println("Getting users...");
        System.out.println("limit: "+limit);
        System.out.println("offset: "+offset);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", "14");
        responseHeaders.add("Access-Control-Expose-Headers", "x-total-count");
        responseHeaders.set("ETag", String.valueOf(new Date()));
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        List<AdminUser> adminUserList = adminUserRepository.findByFilters(limit, offset);
        System.out.println(adminUserList);
        return new ResponseEntity<List<AdminUser>>(adminUserList, responseHeaders, HttpStatus.OK);
    }


    @PostMapping("/adminUsers")
    AdminUser createEmployee(@RequestBody AdminUser adminUser) {
        System.out.println("createEmployee....");
        System.out.println(adminUser);
        return adminUserRepository.save(adminUser);
    }
}
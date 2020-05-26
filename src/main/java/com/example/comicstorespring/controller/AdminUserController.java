package com.example.comicstorespring.controller;


import com.example.comicstorespring.dao.AdminUserRepository;
import com.example.comicstorespring.model.AdminUser;
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

//    https://chariotsolutions.com/blog/post/angular-2-spring-boot-jwt-cors_part1/
//    https://spring.io/guides/gs/rest-service-cors/
    AdminUserController(AdminUserRepository repository) {
        this.adminUserRepository = repository;
    }
//https://stackoverflow.com/questions/29934703/access-control-expose-headers-configuration-for-custom-response-headers-angularj
//    https://www.baeldung.com/spring-response-header
    //http://localhost:8080/adminusers
//https://stackoverflow.com/questions/48184107/read-response-headers-from-api-response-angular-5-typescript/48184742
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @GetMapping("/adminUsers")
//    ResponseEntity<List<AdminUser>> all() {
//        System.out.println("Getting users...");
//
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("x-total-count", "14");
//
//        return new ResponseEntity<List<AdminUser>>(adminUserRepository.findAll(), responseHeaders, HttpStatus.OK);
////        return adminUserRepository.findAll();
//    }


//    https://github.com/carlvdl/comic-store-angular-backup/blob/master/src/app/services/user.service.ts
//    response.headers.get('x-total-count')

    //@CrossOrigin(origins = "*", allowedHeaders = "*")

//https://stackoverflow.com/questions/48184107/read-response-headers-from-api-response-angular-5-typescript
    //@CrossOrigin(allowedHeaders = "*")
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @CrossOrigin(origins = "*")
//    @CrossOrigin(allowedHeaders = "*")
//    @CrossOrigin(origins = "*")
    @GetMapping("/adminUsers")
    ResponseEntity<List<AdminUser>> all() {
        System.out.println("Getting users...");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", "14");
        responseHeaders.set("Response-Header","Steve");

//        this is the weiredest shit I have seen in a long time
        responseHeaders.add("Access-Control-Expose-Headers", "x-total-count");
//        Access-Control-Expose-Headers
//        esponse.Cache.SetLastModified(DateTime.Now);
        responseHeaders.set("ETag", String.valueOf(new Date()));
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        return ResponseEntity.accepted()
                .headers(responseHeaders)
                .body(adminUserRepository.findAll());
//        return new ResponseEntity<List<AdminUser>>(adminUserRepository.findAll(), responseHeaders, HttpStatus.OK);
//        return adminUserRepository.findAll();
    }



    @PostMapping("/adminUsers")
    AdminUser createEmployee(@RequestBody AdminUser adminUser) {
        System.out.println("createEmployee....");
        System.out.println(adminUser);
        return adminUserRepository.save(adminUser);
    }
}
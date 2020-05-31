package com.example.comicstorespring.controller;
import com.example.comicstorespring.model.AdminUserFile;
import org.slf4j.Logger;

import com.example.comicstorespring.model.AdminUser;
import com.example.comicstorespring.service.AdminUserService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class AdminUserController {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    private AdminUserService adminUserService;

    AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }



    @GetMapping("/adminUsers")
    ResponseEntity<List<AdminUser>> findAll(@RequestParam(name="limit",required = false, defaultValue = "3") Integer limit,
                                        @RequestParam(name="offset", required = false, defaultValue = "2") Integer offset) {

        System.out.println("\n");
        System.out.println("Getting users...");
        System.out.println("limit: "+limit);
        System.out.println("offset: "+offset);

        BigInteger totalCount = adminUserService.getAdminUserCount();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(totalCount));
        responseHeaders.add("Access-Control-Expose-Headers", "x-total-count");
        responseHeaders.set("ETag", String.valueOf(new Date()));

        List<AdminUser> adminUserList = adminUserService.findByFilters(limit, offset);
        return new ResponseEntity<List<AdminUser>>(adminUserList, responseHeaders, HttpStatus.OK);

    }

    //https://www.programcreek.com/java-api-examples/?api=org.springframework.http.ResponseEntity
    @DeleteMapping("/adminsUser/{id}")
    ResponseEntity<Long> delete(@PathVariable Long id){
        AdminUser adminUser = adminUserService.findById(id);
        if(adminUser != null){
            adminUserService.delete(adminUser);
        }
        return new ResponseEntity<Long>(id, HttpStatus.NOT_FOUND);
    }

    //https://spring.io/guides/tutorials/rest/
    //https://www.programcreek.com/java-api-examples/?api=org.springframework.http.ResponseEntity
    @PostMapping("/adminUser")
    ResponseEntity<AdminUser> createEmployee(@RequestBody AdminUser adminUser) {
        System.out.println("createEmployee...."+adminUser);
        return new ResponseEntity<AdminUser>(adminUser, HttpStatus.OK);
    }


    @PutMapping("/adminUser/{id}")
    ResponseEntity<AdminUser> updateEmployee(@RequestBody AdminUser adminUser,
                             @PathVariable Long id) {
        try {
            if (adminUser.getAdminUserId() == id) {
                System.out.println("updateEmployee...." + adminUser);
                adminUser = adminUserService.save(adminUser);
                return new ResponseEntity<AdminUser>(adminUser, HttpStatus.OK);
            }
            return new ResponseEntity<AdminUser>(adminUser, HttpStatus.NOT_FOUND);
        }catch (Exception ex){
            return new ResponseEntity<AdminUser>(adminUser, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//
//    @GetMapping("/books/{id}")
//    Book findOne(@PathVariable Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new BookNotFoundException(id));
//    }
//

    //https://mkyong.com/spring-boot/spring-rest-hello-world-example/
//    https://www.journaldev.com/2552/spring-rest-example-tutorial-spring-restful-web-services
    @GetMapping("/adminUser/{id}")
    public @ResponseBody AdminUser getAdminUserById(@PathVariable("id") Long adminUserId) {
        logger.info("Start AdminUser. ID="+adminUserId);

        return adminUserService.findById(adminUserId);
    }

}
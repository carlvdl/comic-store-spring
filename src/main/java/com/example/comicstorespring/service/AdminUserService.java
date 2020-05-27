package com.example.comicstorespring.service;

import com.example.comicstorespring.dao.AdminUserRepository;
import com.example.comicstorespring.model.AdminUser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Service
public class AdminUserService {

    private AdminUserRepository adminUserRepository;

    AdminUserService(AdminUserRepository repository) {
        this.adminUserRepository = repository;
    }

    public List<AdminUser> findByFilters(Integer limit, Integer offset) {

        List<AdminUser> adminUserList = adminUserRepository.findByFilters(limit, offset);
        System.out.println(adminUserList);
        return adminUserList;
    }


    public BigInteger getAdminUserCount() {
        BigInteger totalCount = adminUserRepository.getAdminUserCount();
//        Integer totalCount = 14;
        return totalCount;
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("x-total-count", "14");
//        responseHeaders.add("Access-Control-Expose-Headers", "x-total-count");
//        responseHeaders.set("ETag", String.valueOf(new Date()));
//        responseHeaders.set("Access-Control-Allow-Origin", "*");
//        return responseHeaders;
    }
}

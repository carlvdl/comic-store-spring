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
import java.util.Optional;

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
        return totalCount;
    }

    public AdminUser save(AdminUser adminUser) {
        adminUser = adminUserRepository.save(adminUser);
        return adminUser;
    }

    public AdminUser update(AdminUser adminUser) {
        adminUser = adminUserRepository.save(adminUser);
        return adminUser;
    }

    public AdminUser findById(Long id) {
        Optional<AdminUser> adminUserOptional =  adminUserRepository.findById(id);
        return adminUserOptional.get();
    }

    public void delete(AdminUser adminUser) {
        System.out.println("deleting for now:");
        adminUserRepository.delete(adminUser);
    }

}

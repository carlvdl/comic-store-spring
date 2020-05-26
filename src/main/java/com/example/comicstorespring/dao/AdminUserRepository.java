package com.example.comicstorespring.dao;

//public class AdminUserRepository {



import com.example.comicstorespring.model.AdminUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminUserRepository extends CrudRepository<AdminUser, Long> {

    List<AdminUser> findByEmail(String email);

    List<AdminUser> findAll();

}


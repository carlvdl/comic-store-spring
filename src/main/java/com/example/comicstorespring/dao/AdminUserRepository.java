package com.example.comicstorespring.dao;

import com.example.comicstorespring.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminUserRepository extends JpaRepository<AdminUser,Long> , AdminUserRepositoryCustom{

}

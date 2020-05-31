package com.example.comicstorespring.dao;

import com.example.comicstorespring.model.AdminUser;
import com.example.comicstorespring.model.AdminUserFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminUserFileRepository extends JpaRepository<AdminUserFile,Long>{

}

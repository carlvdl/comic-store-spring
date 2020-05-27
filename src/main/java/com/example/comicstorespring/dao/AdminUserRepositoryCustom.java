package com.example.comicstorespring.dao;

import com.example.comicstorespring.model.AdminUser;

import java.util.List;

public interface AdminUserRepositoryCustom {

    List<AdminUser> findByFilters(Integer limit, Integer offset);
}

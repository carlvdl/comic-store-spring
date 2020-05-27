package com.example.comicstorespring.dao;


import com.example.comicstorespring.model.AdminUser;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.List;

public class AdminUserRepositoryImpl   implements AdminUserRepositoryCustom{


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<AdminUser> findByFilters(Integer limit, Integer offset) {

        StringBuilder stringBuilder = new StringBuilder("select au.* from admin_user au ");
        stringBuilder.append(" order by admin_user_id desc ");
        stringBuilder.append("   offset ?1  limit ?2  ");

        Query query = entityManager.createNativeQuery(stringBuilder.toString(), AdminUser.class);
        query.setParameter(1, offset);
        query.setParameter(2, limit);

        System.out.println("query:   ");
        System.out.println(query);
        return query.getResultList();

    }

    //https://www.objectdb.com/java/jpa/query/execute
    @Override
    public BigInteger getAdminUserCount() {
        System.out.println("getAdminUserCount: ");
        String sqlString = "select count(admin_user_id) from admin_user";
        Query query = entityManager.createNativeQuery(
                sqlString);
        BigInteger adminUserCount = (BigInteger) query.getSingleResult();
        System.out.println("adminUserCount: "+adminUserCount);
        return adminUserCount;
    }


}


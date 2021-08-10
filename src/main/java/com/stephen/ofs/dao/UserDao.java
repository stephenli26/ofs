package com.stephen.ofs.dao;

import com.stephen.ofs.dao.entity.OfsUser;
import com.stephen.ofs.dao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<OfsUser,Integer> {
    @Query("select c from ofs_role_user c where c.customerId = :customerId")
    List<Role> findRolesById(int customerId);

    OfsUser findByUserName(String userName);
}

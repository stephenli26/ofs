package com.stephen.ofs.dao;

import com.stephen.ofs.dao.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao extends JpaRepository<Permission,Integer> {

    Permission findByCode(int code);
}

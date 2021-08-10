package com.stephen.ofs.dao;

import com.stephen.ofs.dao.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RolePermissionDao extends JpaRepository<RolePermission,Integer>{
    @Query("select c from ofs_role_permission c where c.role_code = :role_code")
    List<RolePermission> findRolePermissionByRoleId(int role_code);


}
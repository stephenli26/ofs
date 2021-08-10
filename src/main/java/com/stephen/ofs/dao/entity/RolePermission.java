package com.stephen.ofs.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "ofs_role_permission")
public class RolePermission {
    @Id
    @GeneratedValue
    @Column(name = "code", unique = true, nullable = false)
    private int code;

    @Column(name = "role_code", unique = true, nullable = false)
    private int roleCode;

    @Column(name = "permission_code", unique = true, nullable = false)
    private int permissionCode;
}

package com.stephen.ofs.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity(name = "ofs_user")
public class OfsUser implements Serializable {

    private static final long serialVersionUID = 8655851615465363473L;


    @Id
    @GeneratedValue
    @Column(name = "customer_id", unique = true, nullable = false)
    private int customerId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}

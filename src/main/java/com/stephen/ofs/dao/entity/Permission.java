package com.stephen.ofs.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "ofs_permission")
public class Permission implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "code", unique = true, nullable = false)
    private int code;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;
}

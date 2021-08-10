package com.stephen.ofs.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "ofs_role")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "code", unique = true, nullable = false)
    private int code;
}

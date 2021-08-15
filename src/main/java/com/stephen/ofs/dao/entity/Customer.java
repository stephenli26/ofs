package com.stephen.ofs.dao.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "customer")
public class Customer implements Serializable {

    @Id
    private int customerId;

    private String userName;

    private String password;

    private String level;
}

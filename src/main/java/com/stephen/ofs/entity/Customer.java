package com.stephen.ofs.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "customer")
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String level;
}

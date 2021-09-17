package com.stephen.ofs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "query_data")
public class QueryData {
    @Id
    private int userId;

    private int code;

    private int duty;
    private int name;
}

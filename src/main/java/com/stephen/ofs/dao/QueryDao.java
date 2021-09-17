package com.stephen.ofs.dao;


import com.stephen.ofs.entity.QueryData;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QueryDao  extends JpaRepository<QueryData, Integer> {

    @Query(value = "SELECT q FROM query_data q where q.code = ?1 order by q.duty, q.name")
    List<QueryData> findByCode(int code);
}

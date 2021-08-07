package com.stephen.ofs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<OfsUser,Integer> {
    @Query("select c from ofs_user c where c.customerId = :customerId")
    OfsUser findCustomerById(int customerId);
}

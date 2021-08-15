package com.stephen.ofs.dao;

import com.stephen.ofs.dao.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

    Customer findByCustomerId(int customerId);

    Customer findByUserName(String userName);
}

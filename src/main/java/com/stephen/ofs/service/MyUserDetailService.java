package com.stephen.ofs.service;

import com.stephen.ofs.dao.CustomerDao;
import com.stephen.ofs.dao.entity.CustomerDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    CustomerDao customerDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new CustomerDetail(customerDao.findByUserName(userName));
    }
}

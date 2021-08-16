package com.stephen.ofs.controller;

import com.stephen.ofs.dao.CustomerDao;
import com.stephen.ofs.dao.entity.Customer;
import com.stephen.ofs.service.MyUserDetailService;
import com.stephen.ofs.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    MyUserDetailService userDetailService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goUploadImg(String userName, String password) {
        Customer customer = customerDao.findByUserName(userName);
        if (customer != null) {
            String passwordValue = customer.getPassword();
            if (passwordValue.equals(password)) {
                UserDetails userDetails = userDetailService.loadUserByUsername(userName);
                return jwtTokenUtil.generateToken(userDetails);
            }
        }
        return "401";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "welcome";
    }
}

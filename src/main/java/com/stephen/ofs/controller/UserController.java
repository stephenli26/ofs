package com.stephen.ofs.controller;

import com.stephen.ofs.constant.ErrorCode;
import com.stephen.ofs.dao.CustomerDao;
import com.stephen.ofs.entity.Customer;
import com.stephen.ofs.entity.model.CommonResult;
import com.stephen.ofs.entity.model.CustomerDetail;
import com.stephen.ofs.utils.CommonResultTemplate;
import com.stephen.ofs.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public CommonResult goUploadImg(String userName, String password) {
        Customer customer = customerDao.findByUserName(userName);
        if (customer != null) {
            String passwordValue = customer.getPassword();
            if (passwordValue.equals(password)) {
                UserDetails userDetails = new CustomerDetail(customer);
                String jwt = jwtTokenUtil.generateToken(userDetails);
                return CommonResultTemplate.execute(() -> jwt);
            }
        }
        return new CommonResult();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public CommonResult test() {
        return new CommonResult();
    }
}

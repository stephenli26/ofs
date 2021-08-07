package com.stephen.ofs.controller;

import com.stephen.ofs.dao.IUserDao;
import com.stephen.ofs.dao.OfsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private IUserDao userDao;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public OfsUser goUploadImg(String customerId) {
        return userDao.findCustomerById(Integer.parseInt(customerId));
    }
}

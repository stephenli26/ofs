package com.stephen.ofs.controller;

import com.stephen.ofs.dao.UserDao;
import com.stephen.ofs.dao.entity.OfsUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String goUploadImg(String customerId) {

        OfsUser user = userDao.findCustomerById(Integer.parseInt(customerId));

        log.info("get user! {}", user);
        redisTemplate.opsForValue().set("user", user);

        Object userTemp = redisTemplate.opsForValue().get("user");

        log.info("get redis data, user: {}", userTemp);
        return "welcome";
    }
}

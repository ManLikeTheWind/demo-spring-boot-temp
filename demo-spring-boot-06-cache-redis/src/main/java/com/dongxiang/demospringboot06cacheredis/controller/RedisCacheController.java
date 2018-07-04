package com.dongxiang.demospringboot06cacheredis.controller;

import com.dongxiang.demospringboot06cacheredis.dao.entities.User;
import com.dongxiang.demospringboot06cacheredis.dao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping(value = {"/RedisCacheController"})
public class RedisCacheController {

    private static final Logger mLogger=LoggerFactory.getLogger(RedisCacheController.class);

    private UserService mUserService;

    @Autowired
    public RedisCacheController(UserService userService) {
        mUserService = userService;
    }


    @RequestMapping(value = {"/get"})
    public Object get(){
        User user=mUserService.saveOrUpdate(new User(5l,"u5","p5"));
        mLogger.info("saveOrUpdate - [{}]", user);
        User user1=mUserService.get(5l);
        mLogger.info("[get] - [{}]", user1);

        mUserService.delete(5l);
        return user1;
    }


}

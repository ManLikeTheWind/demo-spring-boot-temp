package com.dongxiang.demospringboot04mybatise1.controller;

import com.dongxiang.demospringboot04mybatise1.dao.entities.User;
import com.dongxiang.demospringboot04mybatise1.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/UserController2"})
public class UserController2 {

    private UserMapper mUserMapper;
    @Autowired
    public UserController2(UserMapper userMapper) {
        mUserMapper = userMapper;
    }

    @ResponseBody
    @RequestMapping(value = {"/index",""})
    public Object index(){
        return new User();
    }

    @ResponseBody
    @RequestMapping(value = {"/queryUserByPrimaryId/id={id}"})
    public Object queryUserByPrimaryId(@PathVariable Integer id){

        return mUserMapper.selectByPrimaryKey(id);
    }


}

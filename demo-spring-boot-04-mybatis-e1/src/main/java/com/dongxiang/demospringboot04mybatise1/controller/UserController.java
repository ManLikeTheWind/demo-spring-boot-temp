package com.dongxiang.demospringboot04mybatise1.controller;

import com.dongxiang.demospringboot04mybatise1.dao.entities.User;
import com.dongxiang.demospringboot04mybatise1.dao.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/UserController"})
public class UserController {

    private UserService mUserService;

    @Autowired
    public UserController(UserService userService) {
        mUserService = userService;
    }

    @ResponseBody
    @RequestMapping(value = {"/index",""})
    public Object index(){
        return new User();
    }

    @ResponseBody
    @RequestMapping(value = {"/queryUserByPrimaryId/id={id}"})
    public Object queryUserByPrimaryId(@PathVariable Integer id){

       return mUserService.selectByPrimaryKey(id);
    }

    @ResponseBody
    @RequestMapping(value = {"/add"},produces = "application/json;charset=utf-8")
    public int addUser(User user){
        return mUserService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/findAllUser/pageNum={pageNum}&pageSize={pageSize}")
    public Object findAllUser(@PathVariable int pageNum,@PathVariable int pageSize){

        return mUserService.findAllUser(pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/findPagerInfo/pageNum={pageNum}&pageSize={pageSize}")
    public Object findPagerInfo(@PathVariable int pageNum,@PathVariable int pageSize){

        return mUserService.findPagerInfo(pageNum, pageSize);
    }


}

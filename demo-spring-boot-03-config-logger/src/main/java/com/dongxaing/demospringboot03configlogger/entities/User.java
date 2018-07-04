package com.dongxaing.demospringboot03configlogger.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 文件名：com.dongxaing.demospringboot03configlogger.entities.User
 * <br>   作者：Dongxiang
 * <br>   邮箱：dongxiang_android_sdk@aliyun.com
 * <br>   时间：2018/7/4 21:36
 * <br>   版本： 1.0
 * <br>   功能：
 * <br>   使用：
 * <p>   注释：
 * <li></li>
 * Copyright (c) 2018 Dongxiang-Personal. All rights reserved.
 */
@ApiModel
public class User implements Serializable {
    private static final long serialVersionID = 1l;

    @ApiModelProperty(value = "用户年龄")
    private int age;
    @ApiModelProperty(value = "用户账号")
    private String nameuser;
    @ApiModelProperty(value = "用户密码")
    private String password;
    @ApiModelProperty(value = "主键")
    private Integer id=0;

    public User() {
    }

    public User(int age, String nameuser, String password) {
        setAge(age);
        setNameuser(nameuser);
        setPassword(password);
    }

    public User(int age, String nameuser, String password, Integer id) {
        setAge(age);
        setNameuser(nameuser);
        setPassword(password);
        setId(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", nameuser='" + nameuser + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = StringUtils.isEmpty(nameuser) ? "" : nameuser.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtils.isEmpty(password) ? "" : password.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = StringUtils.isEmpty(id) ? 0 : id;
    }

}

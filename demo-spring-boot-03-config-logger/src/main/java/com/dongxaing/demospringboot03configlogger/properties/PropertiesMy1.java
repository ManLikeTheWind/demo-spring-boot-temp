package com.dongxaing.demospringboot03configlogger.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 文件名：com.dongxaing.demospringboot03configlogger.properties.PropertiesMy1
 * <br>   作者：Dongxiang
 * <br>   邮箱：dongxiang_android_sdk@aliyun.com
 * <br>   时间：2018/7/4 20:55
 * <br>   版本： 1.0
 * <br>   功能：
 * <br>   使用：
 * <p>   注释：
 * <li></li>
 * Copyright (c) 2018 Dongxiang-Personal. All rights reserved.
 */
@Component
@PropertySource(value = {"classpath:application.yml"})
@ConfigurationProperties(prefix = "my1")
public class PropertiesMy1 {

    //TODO 注意 此处的get-set 方法不能缺少，底层是通过反射进行设置参数的
    private int age;
    private String name;
    private String email;

    public PropertiesMy1() {
    }

    @Override
    public String toString() {
        return "PropertiesMy1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

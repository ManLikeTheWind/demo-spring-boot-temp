package com.dongxiang.demospringboot04mybatise1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// TODO 9/9 这里要修改 mapperScan的包名，位置；
@MapperScan(value = {"com.dongxiang.demospringboot04mybatise1.dao.mapper"})
public class DemoSpringBoot04MybatisE1Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBoot04MybatisE1Application.class, args);
    }
}

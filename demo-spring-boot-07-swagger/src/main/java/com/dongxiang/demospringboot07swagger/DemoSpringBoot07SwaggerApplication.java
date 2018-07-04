package com.dongxiang.demospringboot07swagger;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class DemoSpringBoot07SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBoot07SwaggerApplication.class, args);
    }
}

package com.dongxaing.demospringboot03configlogger;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class DemoSpringBoot03ConfigLoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBoot03ConfigLoggerApplication.class, args);
    }
}

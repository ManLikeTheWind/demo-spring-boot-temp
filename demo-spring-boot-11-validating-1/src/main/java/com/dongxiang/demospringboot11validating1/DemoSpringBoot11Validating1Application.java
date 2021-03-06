package com.dongxiang.demospringboot11validating1;

import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class DemoSpringBoot11Validating1Application {

    public static void main(String[] args) {
//        SpringApplication.run(DemoSpringBoot11Validating1Application.class, args);

        //配置banner
        SpringApplication application = new SpringApplication(DemoSpringBoot11Validating1Application.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}

package com.dongxiang.demospringboot01start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class DemoSpringBoot01StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBoot01StartApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext){
        return args -> {
            System.out.println("com.dongxiang.demospringboot01start.DemoSpringBoot01StartApplication.commandLineRunner[applicationContext]: pre");
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beanDefinitionNames);
            Arrays.stream(beanDefinitionNames).forEach(System.out::println);
            System.out.println("com.dongxiang.demospringboot01start.DemoSpringBoot01StartApplication.commandLineRunner[applicationContext]: aft");

        };
    }


}

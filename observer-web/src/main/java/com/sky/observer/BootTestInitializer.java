package com.sky.observer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by gantianxing on 2017/10/9.
 */
@SpringBootApplication
public class BootTestInitializer extends SpringBootServletInitializer {

    /**
     * 让spring boot在tomcat中运行
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootTestInitializer.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootTestInitializer.class, args);
    }
}
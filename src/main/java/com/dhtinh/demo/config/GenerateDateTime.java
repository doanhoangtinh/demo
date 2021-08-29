package com.dhtinh.demo.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class GenerateDateTime {
    @Bean
    @Scope("prototype")
    public String getString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}

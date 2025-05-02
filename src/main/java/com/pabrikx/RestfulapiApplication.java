package com.pabrikx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class RestfulapiApplication {
    public static void main(String[] args){
        SpringApplication.run(RestfulapiApplication.class,args);
        System.out.println("Hello World");
    }
}

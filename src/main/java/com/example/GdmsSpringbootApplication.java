package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@SpringBootApplication
@MapperScan("com.example.dao")
public class GdmsSpringbootApplication{

    public static void main(String[] args) {
        SpringApplication.run(GdmsSpringbootApplication.class, args);
    }

//    @RequestMapping("/")
//    public String index(){
////        可以直接访问：http://localhost:8080/sys/
//        return "../index.jsp";
//    }
}

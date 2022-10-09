package com.example.zhitongguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MinitwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinitwitterApplication.class, args);
    }

}

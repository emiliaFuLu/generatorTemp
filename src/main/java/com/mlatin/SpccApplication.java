package com.mlatin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mlatin.codegen.dao")
public class SpccApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpccApplication.class, args);
    }

}

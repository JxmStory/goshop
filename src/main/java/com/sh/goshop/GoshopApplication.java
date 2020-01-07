package com.sh.goshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.sh.goshop.dao"}) //dao类无需再加@Mapper
@SpringBootApplication
public class GoshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoshopApplication.class, args);
    }

}

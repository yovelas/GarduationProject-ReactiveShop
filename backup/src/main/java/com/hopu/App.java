package com.hopu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@MapperScan("com.hopu.mapper")
public class App {

//    @CrossOrigin(allowCredentials="true")
//    @GetMapping(path = "/")
//    ModelAndView home() {
//        return new ModelAndView("index.html");
//    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

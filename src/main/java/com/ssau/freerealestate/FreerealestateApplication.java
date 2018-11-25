package com.ssau.freerealestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FreerealestateApplication {
    @RequestMapping("/")
    public String welcome() {
        return "Welcome to osu!";
    }

    public static void main(String[] args) {
        SpringApplication.run(FreerealestateApplication.class, args);
    }
}

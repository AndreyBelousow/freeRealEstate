package com.ssau.freerealestate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssau.freerealestate.model.postgresqlModel.User;
import com.ssau.freerealestate.model.postgresqlModel.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class FreeRealEstateApplication {

    final
    UserServiceImpl us;

    @Autowired
    public FreeRealEstateApplication(UserServiceImpl us) {
        this.us = us;
    }

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to osu!";
    }

    @RequestMapping("/fuckers/add")
    public String addSomeOne() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("FuckFace");
            user.setRole("Fucker");
            user.setPassword("My mom has big pussy");
            us.create(user);
        }
        return "Lol";
    }

    @RequestMapping("/fuckers/show")
    public String showBithes() {
        List<User> users = new ArrayList<>();
        users = us.getAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(FreeRealEstateApplication.class, args);
    }
}

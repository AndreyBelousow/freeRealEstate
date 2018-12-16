package com.ssau.freerealestate.controllers.api.prod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssau.freerealestate.model.postgresqlModel.User;
import com.ssau.freerealestate.model.postgresqlModel.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UsersRESTController {

    final UserServiceImpl userService;

    @Autowired
    public UsersRESTController(UserServiceImpl us){userService = us;}

    @RequestMapping(value = "/add")
    public void addUser(@RequestParam("userId") String userId,
                        @RequestParam("name") String name,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role){
        User user = userService.getById(Integer.parseInt(userId));
        user.setUsername(name);
        user.setPassword(password);
        user.setRole(role);
        userService.create(user);
    }

    @RequestMapping(value = "/get")
    public String getUser(@RequestParam("userId") String userId){
        User user = userService.getById(Integer.parseInt(userId));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(user);
    }

    @RequestMapping("/getAll")
    public String getAllUsers(){
        List<User> users = new ArrayList<>();
        users = userService.getAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(users);
    }

    @RequestMapping("/update")
    public void updateUser(@RequestParam("userId") String userId,
                           @RequestParam("name") String name,
                           @RequestParam("password") String password,
                           @RequestParam("role") String role){
        User user = userService.getById(Integer.parseInt(userId));
        user.setUsername(name);
        user.setPassword(password);
        user.setRole(role);
        userService.update(user);
    }

    @RequestMapping("/delete")
    public void deleteUser(@RequestParam("userId") String userId){
        userService.delete(Integer.parseInt(userId));
    }
}

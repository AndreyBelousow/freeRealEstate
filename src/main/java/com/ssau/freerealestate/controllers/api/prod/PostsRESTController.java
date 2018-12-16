package com.ssau.freerealestate.controllers.api.prod;

import com.ssau.freerealestate.model.postgresqlModel.services.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/posts")
public class PostsRESTController {

    final PostServiceImpl postService;

    @Autowired
    public PostsRESTController(PostServiceImpl ps){postService = ps;}

    @RequestMapping(value = "/add")
    public void addPost(@RequestParam("postId") String postId,
                        @RequestParam("isValid") String isValid){
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

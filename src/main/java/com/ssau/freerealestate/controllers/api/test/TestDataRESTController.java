package com.ssau.freerealestate.controllers.api.test;

import com.ssau.freerealestate.model.postgresqlModel.*;
import com.ssau.freerealestate.model.postgresqlModel.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/test")
public class TestDataRESTController {

    @Autowired
    public TestDataRESTController(UserServiceImpl us, TraderServiceImpl ts, RealEstateServiceImpl rs,
                                  PostServiceImpl ps){
        userService = us;
        traderService = ts;
        realEstateService = rs;
        postService = ps;
    }

    private UserServiceImpl userService;
    private TraderServiceImpl traderService;
    private RealEstateServiceImpl realEstateService;
    private PostServiceImpl postService;

    @RequestMapping("/addTestData")
    public String addTestData(){
        addPosts(addRealEstate(addTraders(addUsers(10))));
        return "Test data added successfully";
    }

    private List<User> addUsers(int count){
        List<User> res = new ArrayList<User>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setUsername(String.format("user%s", i));
            user.setRole("user");
            user.setPassword("12345");
            userService.create(user);
            res.add(user);
        }
        return res;
    }

    private List<Trader> addTraders(List<User> users){
        List<Trader> res = new ArrayList<Trader>();
        for (int i = 0; i < users.size(); i++) {
            Trader trader = new Trader();
            trader.setUser(users.get(i));
            trader.setId(i);
            trader.setName(String.format("trader%s", i));
            trader.setInfo("This is a sample trader description");
            traderService.create(trader);
            res.add(trader);
        }
        return res;
    }

    private List<RealEstate> addRealEstate(List<Trader> traders){
        List<RealEstate> res = new ArrayList<RealEstate>();
        for (int i = 0; i < traders.size(); i++) {
            RealEstate re = new RealEstate();
            re.setTrader(traders.get(i));
            re.setId(i);
            re.setName(String.format("estate%s", i));
            re.setInfo("This is a sample real estate description");
            realEstateService.create(re);
            res.add(re);
        }
        return res;
    }

    private void addPosts(List<RealEstate> re){
        for (int i = 0; i < re.size(); i++) {
            Post post = new Post();
            post.setRealEstate(re.get(i));
            post.setDate(Date.valueOf(LocalDate.now()));
            post.setId(i);
            post.setValid(true);
            postService.create(post);
        }
    }
}

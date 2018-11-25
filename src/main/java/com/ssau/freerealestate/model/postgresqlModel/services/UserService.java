package com.ssau.freerealestate.model.postgresqlModel.services;

import com.ssau.freerealestate.model.postgresqlModel.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void delete(int id);
    void delete(User user);
    User getById(int id);
    List<User> getAll();
}

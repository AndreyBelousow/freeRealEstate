package com.ssau.freerealestate.model.postgresqlModel.services.impl;

import com.ssau.freerealestate.model.postgresqlModel.User;
import com.ssau.freerealestate.model.postgresqlModel.repositories.UserRepository;
import com.ssau.freerealestate.model.postgresqlModel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void create(User user) {
        repository.saveAndFlush(user);
    }

    @Override
    public void update(User user) {
        repository.saveAndFlush(user);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public User getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }
}

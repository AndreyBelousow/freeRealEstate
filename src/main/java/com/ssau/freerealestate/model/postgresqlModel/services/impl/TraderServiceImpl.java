package com.ssau.freerealestate.model.postgresqlModel.services.impl;

import com.ssau.freerealestate.model.postgresqlModel.Trader;
import com.ssau.freerealestate.model.postgresqlModel.repositories.TraderRepository;
import com.ssau.freerealestate.model.postgresqlModel.services.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraderServiceImpl implements TraderService {

    @Autowired
    private TraderRepository repository;

    @Override
    public void create(Trader trader) {
        repository.saveAndFlush(trader);
    }

    @Override
    public void update(Trader trader) {
        repository.saveAndFlush(trader);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(Trader user) {
        repository.delete(user);
    }

    @Override
    public Trader getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<Trader> getAll() {
        return repository.findAll();
    }
}

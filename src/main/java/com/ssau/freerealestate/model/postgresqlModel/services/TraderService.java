package com.ssau.freerealestate.model.postgresqlModel.services;

import com.ssau.freerealestate.model.postgresqlModel.Trader;

import java.util.List;

public interface TraderService {
    void create(Trader trader);
    void update(Trader trader);
    void delete(int id);
    void delete(Trader trader);
    Trader getById(int id);
    List<Trader> getAll();
}

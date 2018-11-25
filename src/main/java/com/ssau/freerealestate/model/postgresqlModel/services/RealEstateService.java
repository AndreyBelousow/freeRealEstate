package com.ssau.freerealestate.model.postgresqlModel.services;

import com.ssau.freerealestate.model.postgresqlModel.RealEstate;

import java.util.List;

public interface RealEstateService {
    void create(RealEstate realEstate);
    void update(RealEstate realEstate);
    void delete(int id);
    void delete(RealEstate realEstate);
    RealEstate getById(int id);
    List<RealEstate> getAll();
}

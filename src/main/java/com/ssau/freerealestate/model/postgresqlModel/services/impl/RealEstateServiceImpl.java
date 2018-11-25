package com.ssau.freerealestate.model.postgresqlModel.services.impl;

import com.ssau.freerealestate.model.postgresqlModel.RealEstate;
import com.ssau.freerealestate.model.postgresqlModel.repositories.RealEstateRepository;
import com.ssau.freerealestate.model.postgresqlModel.services.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateServiceImpl implements RealEstateService {

    @Autowired
    private RealEstateRepository repository;

    @Override
    public void create(RealEstate realEstate) {
        repository.saveAndFlush(realEstate);
    }

    @Override
    public void update(RealEstate realEstate) {
        repository.saveAndFlush(realEstate);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(RealEstate realEstate) {
        repository.delete(realEstate);
    }

    @Override
    public RealEstate getById(int id) {
        return repository.getOne(id);
    }

    @Override
    public List<RealEstate> getAll() {
        return repository.findAll();
    }
}

package com.ssau.freerealestate.model.postgresqlModel.repositories;

import com.ssau.freerealestate.model.postgresqlModel.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateRepository extends JpaRepository<RealEstate, Integer>{

}


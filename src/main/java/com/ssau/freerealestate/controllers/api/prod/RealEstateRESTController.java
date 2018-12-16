package com.ssau.freerealestate.controllers.api.prod;

import com.ssau.freerealestate.model.postgresqlModel.services.impl.RealEstateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/realEstate")
public class RealEstateRESTController {

    final RealEstateServiceImpl realEstateService;

    @Autowired
    public RealEstateRESTController(RealEstateServiceImpl rs){realEstateService = rs;}
}

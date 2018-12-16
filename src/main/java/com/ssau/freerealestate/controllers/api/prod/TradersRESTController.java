package com.ssau.freerealestate.controllers.api.prod;

import com.ssau.freerealestate.model.postgresqlModel.services.impl.TraderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/traders")
public class TradersRESTController {

    final TraderServiceImpl tradersService;

    @Autowired
    public TradersRESTController(TraderServiceImpl ts){tradersService = ts;}
}

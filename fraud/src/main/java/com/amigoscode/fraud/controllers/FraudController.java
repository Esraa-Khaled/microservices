package com.amigoscode.fraud.controllers;

import com.amigoscode.fraud.responses.FraudCheckResponse;
import com.amigoscode.fraud.services.FraudCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {

    @Autowired
    FraudCheckService fraudCheckService;

    @GetMapping(path="{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        boolean isFraudulentCustomer = fraudCheckService.
                isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}

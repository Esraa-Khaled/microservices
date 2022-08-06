package com.amigoscode.customer.controllers;

import com.amigoscode.customer.requests.CustomerRegisterationRequest;
import com.amigoscode.customer.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegisterationRequest customerRegisterationRequest) {
        log.info("new customer registeration {}", customerRegisterationRequest);
        customerService.registerCustomer(customerRegisterationRequest);
    }
}

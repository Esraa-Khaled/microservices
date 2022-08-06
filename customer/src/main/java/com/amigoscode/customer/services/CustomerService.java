package com.amigoscode.customer.services;

import com.amigoscode.customer.dtos.Customer;
import com.amigoscode.customer.repositories.CustomerRepository;
import com.amigoscode.customer.requests.CustomerRegisterationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegisterationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        // TODO: check if email valid
        // TODO: check if email not taken
        customerRepository.save(customer);

    }
}

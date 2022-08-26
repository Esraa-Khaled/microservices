package com.amigoscode.customer.services;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.customer.dtos.Customer;
import com.amigoscode.customer.repositories.CustomerRepository;
import com.amigoscode.customer.requests.CustomerRegisterationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    FraudClient fraudClient;
    @Autowired
    NotificationClient notificationClient;

    public void registerCustomer(CustomerRegisterationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        // TODO: check if email valid
        // TODO: check if email not taken
        customerRepository.saveAndFlush(customer);

        // TODO: check if fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if(fraudCheckResponse != null && fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
        // TODO: send notification
        // TODO: make it async. i.e add to queue
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setToCustomerId(customer.getId());
        notificationRequest.setToCustomerEmail(customer.getEmail());
        notificationRequest.setMessage(String.format("Hi %s, welcome to Amigoscode....", customer.getFirstName()));
        notificationClient.sendNotification(notificationRequest);

    }
}

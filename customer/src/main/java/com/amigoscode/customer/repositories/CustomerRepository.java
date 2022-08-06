package com.amigoscode.customer.repositories;

import com.amigoscode.customer.dtos.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

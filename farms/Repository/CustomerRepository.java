package com.example.farms.Repository;

import com.example.farms.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer customerId);
}

package com.example.farms.Service;

import com.example.farms.API.ApiException;
import com.example.farms.Model.Customer;
import com.example.farms.Model.Farm;
import com.example.farms.Repository.CustomerRepository;
import com.example.farms.Repository.FarmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class FarmService {
private final CustomerRepository customerRepository;
private final FarmRepository farmRepository;

public List<Farm>getAll(){
    return farmRepository.findAll();
}


    public Farm addFarm(Farm farm, Integer customerId) {
        Customer customer=customerRepository.findCustomerById(customerId);
        if (customer==null) {

            throw new ApiException("Customer not found");
        }
farm.setCustomer(customer);
return farmRepository.save(farm); }
}


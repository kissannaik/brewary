package com.kissan.brewery.service.v1;

import com.kissan.brewery.web.model.v1.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerById(UUID id);

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomer(UUID customerId);
}

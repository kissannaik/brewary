package com.kissan.brewery.service.v2;

import com.kissan.brewery.web.model.v2.CustomerDTO;

import java.util.UUID;

public interface CustomerServiceV2 {
    CustomerDTO getCustomerById(UUID id);

    CustomerDTO addCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomer(UUID customerId);
}

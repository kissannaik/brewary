package com.kissan.brewery.service.v1;

import com.kissan.brewery.web.model.v1.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID id) {
        log.debug("Getting Customer by Id");

        return CustomerDTO.builder()
                .id(id)
                .name("John Hoppkins")
                .build();
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        log.debug("Adding Customer");

        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name(customerDTO.getName())
                .build();
    }

    @Override
    public CustomerDTO updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        log.debug("Updating Customer by Id");

        return CustomerDTO.builder()
                .id(customerId)
                .build();
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting Customer by Id");

    }
}

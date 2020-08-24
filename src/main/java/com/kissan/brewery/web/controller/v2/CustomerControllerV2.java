package com.kissan.brewery.web.controller.v2;

import com.kissan.brewery.service.v2.CustomerServiceV2;
import com.kissan.brewery.web.model.v2.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/customer")
@RestController
public class CustomerControllerV2 {

    private CustomerServiceV2 customerServiceV2;

    public CustomerControllerV2(CustomerServiceV2 customerServiceV2) {
        this.customerServiceV2 = customerServiceV2;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID id){
        CustomerDTO customerDTO = customerServiceV2.getCustomerById(id);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v2/customer/"+customerDTO.getId());

        return new ResponseEntity<>(customerDTO, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO addedCustomerDTO = customerServiceV2.addCustomer(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v2/customer/"+addedCustomerDTO.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO){
        CustomerDTO updatedCustomerDTO = customerServiceV2.updateCustomer(customerId, customerDTO);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v2/customer/"+updatedCustomerDTO.getId());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @DeleteMapping({"/{customerId}"})
    public ResponseEntity deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerServiceV2.deleteCustomer(customerId);

        return new ResponseEntity (HttpStatus.OK);
    }
}

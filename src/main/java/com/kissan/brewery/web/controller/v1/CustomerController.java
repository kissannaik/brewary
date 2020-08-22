package com.kissan.brewery.web.controller.v1;

import com.kissan.brewery.service.v1.CustomerService;
import com.kissan.brewery.web.model.v1.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID id){
        CustomerDTO customerDTO = customerService.getCustomerById(id);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v1/customer/"+customerDTO.getId());

        return new ResponseEntity<>(customerDTO, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO addedCustomerDTO = customerService.addCustomer(customerDTO);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v1/customer/"+addedCustomerDTO.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO){
        CustomerDTO updatedCustomerDTO = customerService.updateCustomer(customerId, customerDTO);

        HttpHeaders headers = new HttpHeaders();
        // todo add hostname to url
        headers.add("Location", "/api/v1/customer/"+updatedCustomerDTO.getId());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @DeleteMapping({"/{customerId}"})
    public ResponseEntity deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomer(customerId);

        return new ResponseEntity (HttpStatus.OK);
    }
}

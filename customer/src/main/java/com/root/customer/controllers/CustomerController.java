package com.root.customer.controllers;

import com.root.customer.models.CustomerRegistertionRequest;
import com.root.customer.services.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void registerRequest(@RequestBody CustomerRegistertionRequest customerRequest){
        log.info("new customer registration {} " , customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}

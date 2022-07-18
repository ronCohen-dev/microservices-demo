package com.root.fraud.controllers;

import com.root.clients.fraud.FraudCheckResponse;
import com.root.fraud.services.FraudCheckHistoryServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/fraud-check")
@Slf4j
@RequiredArgsConstructor
public class FraudCheckHistoryController {

    private final FraudCheckHistoryServices fraudCheckHistoryServices;
    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable(value = "customerId") Integer customerId){
        log.info("from FraudCheckHistoryController for {} " ,customerId);
         boolean isFraudulentCustomer  = fraudCheckHistoryServices.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}

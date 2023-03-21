package com.Moonshot.DLTSettlements.controller;


import com.Moonshot.DLTSettlements.entity.CurrencyEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
//@RequestMapping("/TransactionService")
public class TransactionController {

    @RequestMapping("/CurrencyList")
    public List<CurrencyEntity> fetchCurrency() {

        //get data from corda dlt api code.
        //RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject("corda url",object)

        //currently hardcoding the value.
        return Collections.singletonList(
                new CurrencyEntity(1, "US Dollar", 2, "USD/GBP")

        );
    }
    @RequestMapping("/")
    public String home(){
        return "DLT Settlement Service Running";
    }

}

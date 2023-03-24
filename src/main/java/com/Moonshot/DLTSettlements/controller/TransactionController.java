package com.Moonshot.DLTSettlements.controller;


import com.Moonshot.DLTSettlements.entity.*;
import com.Moonshot.DLTSettlements.entity.Repo.CurrencyPairRepo;
import com.Moonshot.DLTSettlements.entity.Repo.LegalEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/TransactionService")
public class TransactionController {

    @Autowired
    private LegalEntityRepo entityRepo;

    @Autowired
    private CurrencyPairRepo currencyPairRepo;

    @RequestMapping("/")
    public String getMainPage(){
        return "Welcome to DLT Settlements System - FX";
    }
    @CrossOrigin(origins = "*")
    @RequestMapping("/CurrencyList")
    public List<CurrencyEntity> fetchCurrency(){

        //get data from corda dlt api code.
        //RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject("corda url",object)

        //currently hardcoding the value.
        return Collections.singletonList(
                new CurrencyEntity(1,"US Dollar",2,"USD")

        );

    }
    @RequestMapping("/listUnsettledTrades")
    public List<TradeObject> listUnsettledTrades() {
        return Collections.singletonList(
                new TradeObject());

    }
    @RequestMapping("/listSettledTrades")
    public List<TradeObject> listSettledTrades() {
        return Collections.singletonList(
                new TradeObject());
    }

    @RequestMapping("/counterpartyList")
    public List<CounterParty>  counterpartyList() {
        return Collections.singletonList(
                new CounterParty());
    }

    //Getting data from DB
    @GetMapping("/listCurrencyPairs")
    public List<CurrencyPair> listCurrencyPairs() {
         return currencyPairRepo.findAll();
    }




    @RequestMapping("/books")
    public List<Book> listBooks() {
        return Collections.singletonList(
                new Book());
    }
    //Getting data from DB

    @CrossOrigin(origins = "*")
    @GetMapping("/legalEntities")
    public List<LegalEntity> legalEntities() {
        return entityRepo.findAll();
    }

    @RequestMapping("/currencyQuotes")
    public Map<String,String> currencyQuotes(@RequestParam(value = "currency_pair", defaultValue = "") String name){
        Map<String,String> object = new HashMap<String,String>();
        if(name !=null ) {

            RestTemplate restTemplate = new RestTemplate();
            StringBuilder stringBuilder = new StringBuilder("https://fcsapi.com/api-v3/forex/latest?symbol=");
            stringBuilder.append(name).append("&access_key=wCY1WNYN6ULN4bj9R1tt");
            object = restTemplate.getForObject(stringBuilder.toString(),HashMap.class);
        }
        else
        {
            System.out.println("Either invalid currency pair "+name+", or null/empty currency pair supplied");
        }
        System.out.println(object);
        return object;
    }

    @RequestMapping(value="/submitTrade", method = RequestMethod.POST)
    public void submitTrade(@RequestBody TradeObject payload) throws Exception {
        System.out.println(payload);
    }
}

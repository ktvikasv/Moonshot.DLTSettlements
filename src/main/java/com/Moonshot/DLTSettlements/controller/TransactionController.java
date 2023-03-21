package com.Moonshot.DLTSettlements.controller;


import com.Moonshot.DLTSettlements.entity.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/TransactionService")
public class TransactionController {

    @RequestMapping("/CurrencyList")
    public List<CurrencyEntity> fetchCurrency(){

        //get data from corda dlt api code.
        //RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject("corda url",object)

        //currently hardcoding the value.
        return Collections.singletonList(
                new CurrencyEntity(1,"US Dollar",2,"USD/GBP")

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

    @RequestMapping("/listCurrencyPairs")
    public List<CurrencyPair> listCurrencyPairs() {
        List<CurrencyPair> currencyPairs = new ArrayList<CurrencyPair>();
        RestTemplate restTemplate = new RestTemplate();
        Map object = new HashMap<String,String>();
        object = restTemplate.getForObject("https://fcsapi.com/api-v3/forex/list?type=forex&access_key=wCY1WNYN6ULN4bj9R1tt",HashMap.class);
        System.out.println(object);
        return Collections.singletonList(
                new CurrencyPair());

    }




    @RequestMapping("/books")
    public List<Book> listBooks() {
        return Collections.singletonList(
                new Book());
    }
    @RequestMapping("/legalEntities")
    public List<LegalEntity> legalEntities() {
        return Collections.singletonList(
                new LegalEntity());
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

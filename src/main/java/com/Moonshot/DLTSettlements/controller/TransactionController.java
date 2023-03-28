package com.Moonshot.DLTSettlements.controller;


import com.Moonshot.DLTSettlements.Util.StringPrefixedSequenceIdGenerator;
import com.Moonshot.DLTSettlements.entity.*;
import com.Moonshot.DLTSettlements.entity.Repo.*;
import com.Moonshot.DLTSettlements.service.impl.TradePrepService;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/TransactionService")
public class TransactionController {

    @Autowired
    private LegalEntityRepo entityRepo;

    @Autowired
    private CurrencyPairRepo currencyPairRepo;
    @Autowired
    private TradeObjectRepo tradeObjectRepo;

    @Autowired
    private CounterPartyRepo counterPartyRepo;

    //can be picked from db later
    @Autowired
    private QuoteRepo quoteRepo;

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
    public List<CounterParty>  counterpartyList()  {
        return counterPartyRepo.findAll();
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
    public String currencyQuotes(@RequestParam(value = "currency_pair", defaultValue = "") String name){
        Map<String, Object> object;
        //Map<String,String> object = new HashMap<String,String>();
        String currVal="";
        System.out.print(name);
        if(name !=null ) {

            RestTemplate restTemplate = new RestTemplate();
            StringBuilder stringBuilder = new StringBuilder("https://fcsapi.com/api-v3/forex/latest?symbol=");
            stringBuilder.append(name).append("&access_key=wCY1WNYN6ULN4bj9R1tt");
            object = restTemplate.getForObject(stringBuilder.toString(),HashMap.class);
            ArrayList<Map> response = (ArrayList<Map>) object.get("response");
            Map<String, String> currValMap = response.get(0);

            currVal = currValMap.get("c");
            System.out.print(currVal);
        }
        else
        {
            System.out.println("Either invalid currency pair "+name+", or null/empty currency pair supplied");
        }
       return currVal;
    }

    @PostMapping (value="/submitTrade", consumes = {"*/*"})
    public TradeObject submitTrade(@RequestBody TradeObject payload) throws Exception {
        //db insert
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
        payload.setTradeId("TRFX_"+timeStamp);
        System.out.println("Trade Id" + payload.getTradeId());

        //Insert into DB
        tradeObjectRepo.save(payload);


        //Code to send data to the DLT Node
        TradeDLTObject tradeDLTObject = new TradeDLTObject();
        TradePrepService tradePrepService = new TradePrepService();
        RestTemplate restTemplate = new RestTemplate();
        Map<String,Integer> param = new HashMap<>();
        param.put("id", 1);
        tradeDLTObject = tradePrepService.cloneTradeObjForDLT(payload, tradeDLTObject);

        HttpEntity<TradeDLTObject> request = new HttpEntity<TradeDLTObject>(tradeDLTObject);
        String tradeResponse = restTemplate.postForObject("http://20.235.241.53:10027/api/fx/submitTrade",request, String.class);
        System.out.print(tradeResponse);

        String tradeResponseArray[] = tradeResponse.split("&&");
        String transactionID = tradeResponseArray[0].substring(15);
        System.out.print(transactionID);

        //update flowstatus for the object in DB
        payload.setFlowStatus(transactionID);
        tradeObjectRepo.save(payload);
        /*
        restTemplate.exchange(
                "http://20.235.241.53:10027/api/fx/submitTrade",
                HttpMethod.PUT,
                request,
                Void.class);
*/
        return payload;
        //

    }

    @GetMapping("/getTradeByStatus")
    public List<TradeObject> getTradeByStatus() {
        return tradeObjectRepo.findTradeObjectByStatus("INITIATED");
    }
}

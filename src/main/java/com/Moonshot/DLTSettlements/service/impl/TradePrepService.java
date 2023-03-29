package com.Moonshot.DLTSettlements.service.impl;

import com.Moonshot.DLTSettlements.entity.Book;
import com.Moonshot.DLTSettlements.entity.Repo.TradeObjectRepo;
import com.Moonshot.DLTSettlements.entity.TradeDLTObject;
import com.Moonshot.DLTSettlements.entity.TradeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collections;
import java.util.List;

public class TradePrepService {

    public TradeDLTObject  cloneTradeObjForDLT(TradeObject tradeObject, TradeDLTObject tradeDLTObject) {

        //Silicon Vault Bank NA
        //Bank of Liberty NA
        //Wells Cargo Bank NA
        tradeDLTObject.setResponder("PartyC");
        Integer amount = tradeObject.getAmount();
        Float executionPrice = tradeObject.getExecutionPrice();
        Float buyAmount;
        Float sellAmount;

        if(tradeObject.getDealerSide()=="BUY") {
            buyAmount = amount.floatValue();
            sellAmount = amount * executionPrice;
        }
        if (tradeObject.getDealerSide()=="SELL"); {
            sellAmount = amount.floatValue();
            buyAmount = amount * executionPrice;
        }
        tradeDLTObject.setBuyamount(buyAmount.intValue());
        tradeDLTObject.setSellamount(sellAmount.intValue());
        String Symbol = tradeObject.getCurrencyPair();
        String Curreny[] = Symbol.split("/");
        if(tradeObject.getDealerSide()=="BUY"); {
            tradeDLTObject.setSellcurrency(Curreny[1]);
            tradeDLTObject.setBuycurrency(Curreny[0]);
            System.out.println("BUY"+Curreny[0]);
        }
        if(tradeObject.getDealerSide()=="SELL"); {
            tradeDLTObject.setSellcurrency(Curreny[0]);
            tradeDLTObject.setBuycurrency(Curreny[1]);
        }
        tradeDLTObject.setTradedate(tradeObject.getExecution_date().toString());
        tradeDLTObject.setSettledate(tradeObject.getSettlement_date().toString());
        tradeDLTObject.setExchangerate(tradeObject.getSpotPrice().floatValue());
        tradeDLTObject.setBuysell(tradeObject.getDealerSide());
        //tradeDLTObject.setAmount(tradeObject.getAmount().toString());
        tradeDLTObject.setMatchstatus("UNMATCHED");
        tradeDLTObject.setSettlementstatus("UNSETTLED");


        return tradeDLTObject;
    }

}

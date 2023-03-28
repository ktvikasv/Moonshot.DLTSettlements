package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TradeDLTObject {
    String responder;
    Integer buyamount;
    Integer sellamount;
    String sellcurrency;
    String buycurrency;
    String tradedate;
    String settledate;
    Float exchangerate;
    String buysell;
    /*String tradeId;
    String amount;*/
    String matchstatus;
    String settlementstatus;


}

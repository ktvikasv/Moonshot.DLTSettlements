package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class TradeObject {
    String tradeId;
    String product;
    Float settlement_price;
    Date settlement_date;
    String counterParty;

    String book;
    String legalEntity;

}

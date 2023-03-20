package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyEntity {
    private int currID;
    private String currName;
    private int decimal;
    private String symbol;
}

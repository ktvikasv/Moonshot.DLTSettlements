package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class CurrencyPair {
    private Integer id;
    private String description; // "US Dollar Euro", "US Dollar British Pound","British Pound Euro"
    private int pip; // 4
    private String symbol; // USD/EUR, USD/GBP, GBP/EUR etc.
}

package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CURRENCYPAIR", schema = "dbo")
public class CurrencyPair {
    @Id
    @GeneratedValue
    @Column(name = "CURPAIRID")
    private Integer curPairId;
    @Column(name = "DESCRIPTION")
    private String description; // "US Dollar Euro", "US Dollar British Pound","British Pound Euro"
    @Column(name = "PIP")
    private int pip; // 4
    @Column(name = "SYMBOL")
    private String symbol; // USD/EUR, USD/GBP, GBP/EUR etc.
}

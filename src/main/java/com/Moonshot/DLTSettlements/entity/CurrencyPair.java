package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class CurrencyPair {
    @Id
    @GeneratedValue
    private Integer id;
    private String description; // "US Dollar Euro", "US Dollar British Pound","British Pound Euro"
    private int pip; // 4
    private String symbol; // USD/EUR, USD/GBP, GBP/EUR etc.
}

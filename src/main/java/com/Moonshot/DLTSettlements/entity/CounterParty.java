package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CounterParty {

    private Integer id;
    private String shortName;
    private String longName;
    private String settlementAccount;
    private String assetClass;
    private String assetSubClass;
    private LegalEntity legalEntity;
    private LegalEntity subLegalEntity;
}

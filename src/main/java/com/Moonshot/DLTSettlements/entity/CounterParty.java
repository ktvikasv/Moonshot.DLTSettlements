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
@Table(name="COUNTERPARTY", schema = "dbo")
public class CounterParty {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "SHORTNAME")
    private String shortName;
    @Column(name = "LONGNAME")
    private String longName;
    @Column(name = "SETTLEMENTACCOUNT")
    private String settlementAccount;
    @Column(name = "ASSETCLASS")
    private String assetClass;
    @Column(name = "ASSETSUBCLASS")
    private String assetSubClass;

}

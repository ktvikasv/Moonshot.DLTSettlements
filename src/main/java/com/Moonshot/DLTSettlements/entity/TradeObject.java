package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TRADEOBJECT")
public class TradeObject {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    Integer id;
    @Column(name = "TRADEID")
    String tradeId;
    @Column(name = "PRODUCT")
    String product;
    @Column(name = "EXECUTION_PRICE")
    Float executionPrice;
    @Column(name = "SPOT_PRICE")
    Float spotPrice;
    @Column(name = "SETTLEMENTDATE")
    Date settlement_date;
    @Column(name = "COUNTERPARTY")
    String counterParty;
    @Column(name = "COUNTERPARTYFULLNAME")
    String counterPartyFullName;
    @Column(name = "EXECUTIONDATE")
    Date execution_date;
    @Column(name = "PRICING")
    String pricing;
    @Column(name = "EXECUTIONVENUE")
    String executionVenue;
    @Column(name = "SALESDESK")
    String salesDesk;
    @Column(name = "LIQUIDITYPROVIDER")
    String liquidityProvider;
    @Column(name = "BOOK")
    String book;
    @Column(name = "LEGALENTITY")
    String legalEntity;
    @Column(name = "STATUS")
    String status;
    @Column(name = "DEALERSIDE")
    String dealerSide;
    @Column(name = "CLIENTSIDE")
    String clientSide;
   @Column(name = "FLOWSTATUS")
    String flowStatus;

}

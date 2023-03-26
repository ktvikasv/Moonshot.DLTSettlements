package com.Moonshot.DLTSettlements.entity;

import java.util.Date;
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
@Table(name="QUOTE", schema = "dbo")
public class Quote {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    Integer ID;
    @Column(name = "SYMBOL")
    String symbol;
    @Column(name = "DESCRIPTION")
    String description;
    @Column(name = "OPEN")
    Float open;
    @Column(name = "HIGH")
    Float high;
    @Column(name = "LOW")
    Float low;
    @Column(name = "CLOSE")
    Float close;
    @Column(name = "SPOT_PRICE")
    Float spot_price;
    @Column(name = "SPREAD")
    Float spread;
    @Column(name = "TIMESTAMPUTC")
    Date timestamp_in_utc;
    @Column(name = "SERVERTIME")
    Date server_time_in_utc;
}

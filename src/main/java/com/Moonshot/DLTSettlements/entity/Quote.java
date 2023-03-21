package com.Moonshot.DLTSettlements.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
    String symbol;
    String description;
    Float open;
    Float high;
    Float low;
    Float close;
    Float spot_price;
    Float spread;
    Date timestamp_in_utc;
    Date server_time_in_utc;
}

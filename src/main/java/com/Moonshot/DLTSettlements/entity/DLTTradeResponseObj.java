package com.Moonshot.DLTSettlements.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DLTTradeResponseObj {

    String transactionId;
    String uuid;
    String response;
}

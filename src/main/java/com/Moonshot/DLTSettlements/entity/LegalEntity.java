package com.Moonshot.DLTSettlements.entity;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LegalEntity {
    private Integer id;
    private String name;
    private String createdBy;
    private Date creationDate;

}

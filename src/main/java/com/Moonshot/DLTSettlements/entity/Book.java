package com.Moonshot.DLTSettlements.entity;

import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    private Integer id;
    private String name;
    private String createdBy;
    private String lineOfBusiness;
    private Date creationDate;
    private LegalEntity legalEntity;

}

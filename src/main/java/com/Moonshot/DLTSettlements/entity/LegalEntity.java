package com.Moonshot.DLTSettlements.entity;

import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LEGALENTITY",schema = "dbo")
@Entity
public class LegalEntity {
    @Id
    @GeneratedValue
    @Column(name = "LEID")
    private Integer leID;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CREATEDBY")
    private String createdBy;
    @Column(name = "DATESTAMP")
    private Date dateStamp;

}

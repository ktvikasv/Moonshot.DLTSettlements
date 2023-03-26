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
    @Column(name = "ID")
    private Integer leID;
    @Column(name = "COMPANYNAME")
    private String companyName;
    @Column(name = "LEGALENTITY")
    private String legalEntity;
    @Column(name = "CREATEDBY")
    private String createdBy;
    @Column(name = "CREATEDDATE")
    private Date createdDate;

}

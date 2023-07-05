package com.accounting.domain.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "acc_account_head")
public class AccAccountHead implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "account_code", nullable = false)
    private String accountCode;

    @Column(name = "account_title", nullable = false)
    private String accountTitle;

    @Column(name = "opening_balance")
    private Double openingBalance;

    @Column(name = "opening_date")
    private Date openingDate;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "is_head")
    private Boolean head;

    @Column(name = "is_cash")
    private Boolean cash;

    @Column(name = "is_bank")
    private Boolean bank;

}

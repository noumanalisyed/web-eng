package com.accounting.domain.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "acc_transaction_detail")
public class AccTransactionDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_detail_id", nullable = false)
    private Long transactionDetailId;

    @Column(name = "transaction_id", nullable = false)
    private Long transactionId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "debit_amount")
    private Double debitAmount;

    @Column(name = "credit_amount")
    private Double creditAmount;

    @Column(name = "remarks")
    private String remarks;

}

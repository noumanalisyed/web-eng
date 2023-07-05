package com.accounting.shared.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class AccTransactionDetailDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long transactionDetailId;

    private Long transactionId;

    private Long accountId;

    private Double debitAmount;

    private Double creditAmount;

    private String remarks;

}

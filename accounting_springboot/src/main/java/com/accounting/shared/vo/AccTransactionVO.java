package com.accounting.shared.vo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


@Data
public class AccTransactionVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long transactionId;


    private Integer voucherTypeId;


    private Date transactionDate;


    private Time transactionTime;


    private Double totalAmount;

    private String checkNo;

    private String narration;


    private String enteredBy;

    private Date postingDate;

    private Time postingTime;

    private String postedBy;

}

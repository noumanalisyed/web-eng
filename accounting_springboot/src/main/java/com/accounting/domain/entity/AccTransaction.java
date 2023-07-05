package com.accounting.domain.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "acc_transaction")
public class AccTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "transaction_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "voucher_type_id", nullable = false)
    private Integer voucherTypeId;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;

    @Column(name = "transaction_time", nullable = false)
    private Time transactionTime;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "check_no")
    private String checkNo;

    @Column(name = "narration")
    private String narration;

    @Column(name = "entered_by", nullable = false)
    private String enteredBy;

    @Column(name = "posting_date")
    private Date postingDate;

    @Column(name = "posting_time")
    private Time postingTime;

    @Column(name = "posted_by")
    private String postedBy;

}

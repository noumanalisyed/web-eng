package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ReturnofborrowDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer returnOfBorrowId;

    private Date date;

    private Double netAmountReturn;

    private Integer empId;

    private String status;

    private Date updateTime;

}

package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SalesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer salesId;

    private Date date;

    private Integer empId;

    private Double saleAmount;

    private String salesStatus;

    private Double discounPercentage;

    private Double netAmount;

    private Integer patientsId;

    private Integer salesNumber;

    private Integer returnOfSalesId;

    private Integer paymentTypeId;

    private Integer salesmanSaleDayId;

    private Date updateTime;

}

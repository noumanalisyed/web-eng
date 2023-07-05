package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PaymenttypeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer paymentTypeId;

    private String paymentTypeName;

    private String paymentTypeDisc;

    private Date updateTime;

}

package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer orderId;

    private Integer orderStatusId;

    private String orderNumber;

    private Date orderDate;

    private Integer empId;

    private Integer supplierId;

    private String statusChangedDiscription;

    private Date updateTime;

}

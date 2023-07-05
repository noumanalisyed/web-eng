package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SupplierDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer supplierId;

    private String supplierName;

    private String supplierContactNumber;

    private String supplierEmail;

    private String manufecture;

    private String type;

    private String address;

    private Date updateTime;

}

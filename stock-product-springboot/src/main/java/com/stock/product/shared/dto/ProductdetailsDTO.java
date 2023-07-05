package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductdetailsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer productDetailId;

    private Integer productId;

    private Double productSize;

    private Integer alertBFExpiryDays;

    private Integer thresholdLevel;

    private String barcode;

    private Date updateTime;

}

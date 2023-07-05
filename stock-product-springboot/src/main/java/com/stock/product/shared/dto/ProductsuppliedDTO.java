package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductsuppliedDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer productSuppliedId;

    private Integer productDetailId;

    private Integer supplierId;

    private Date updateTime;

}

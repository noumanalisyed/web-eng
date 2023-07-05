package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer productId;

    private String productName;

    private Integer categoryId;

    private Date updateTime;

}

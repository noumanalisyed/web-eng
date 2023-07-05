package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SoldstockDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer soldStokId;

    private Integer stockId;

    private Integer soldItemId;

    private Integer rowQuantity;

    private Double singleItemPrice;

    private Date updateTime;

}

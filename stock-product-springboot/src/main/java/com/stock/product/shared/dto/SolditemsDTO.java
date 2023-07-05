package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SolditemsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer soldItemId;

    private Integer quantity;

    private Double amount;

    private Integer salesId;

    private Integer productDetailId;

    private Double discountpercent;

    private Date updateTime;

}

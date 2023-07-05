package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderplaceditemsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer orderPlacedItemsId;

    private Integer orderId;

    private Integer quantityOrderd;

    private Integer productSuppliedId;

    private Double ratePrUnit;

    private Integer packSize;

    private Date updateTime;

}

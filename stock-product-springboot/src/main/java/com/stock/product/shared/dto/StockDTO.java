package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StockDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer stockId;

    private Integer productSuppliedId;

    private Integer orderPartialsId;

    private Double sellingPricePrItem;

    private Integer quantity;

    private Integer itemSold;

    private String batchNO;

    private Date expiryDate;

    private Integer quantityReceived;

    private Double pricePrItem;

    private Double discountPercentage;

    private Integer packSize;

    private String barCode;

    private Date updateTime;

}

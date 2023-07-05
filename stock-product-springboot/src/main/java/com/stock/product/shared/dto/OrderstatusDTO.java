package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderstatusDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer orderStatusId;

    private String statusName;

    private String statusDiscription;

    private Date updateTime;

}

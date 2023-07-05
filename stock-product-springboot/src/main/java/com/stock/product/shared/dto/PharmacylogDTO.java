package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PharmacylogDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pharmacyLogId;

    private String userName;

    private String tableName;

    private String actionPerformed;

    private Date date;

    private String discription;

    private Date updateTime;

}

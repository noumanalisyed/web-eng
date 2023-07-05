package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DesignationDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer designationId;

    private String designation;

    private Integer level;

    private Integer parentDesignationId;

    private Date updateTime;

}

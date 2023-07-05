package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer categoryId;

    private String categoryName;

    private String categoryUnit;

    private Date updateTime;

}

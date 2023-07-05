package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AuthoritiesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer authorityId;

    private String authority;

    private Date updateTime;

}

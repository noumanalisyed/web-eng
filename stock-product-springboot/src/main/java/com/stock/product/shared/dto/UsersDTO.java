package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UsersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;

    private String password;

    private Boolean enabled;

    private Integer authorityId;

    private Date updateTime;

}

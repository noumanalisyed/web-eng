package com.accounting.shared.vo;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class AccAccountHeadQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long accountId;

    private Long parentId;

    private String accountCode;

    private String accountTitle;

    private Double openingBalance;

    private Date openingDate;

    private Integer level;

    private Boolean head;

    private Boolean cash;

    private Boolean bank;

}

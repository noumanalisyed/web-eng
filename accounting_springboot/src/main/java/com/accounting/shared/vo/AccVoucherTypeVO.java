package com.accounting.shared.vo;

import lombok.Data;

import java.io.Serializable;


@Data
public class AccVoucherTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer voucherTypeId;


    private String voucherTypeName;


    private String abbreviation;

    private String desc;

}

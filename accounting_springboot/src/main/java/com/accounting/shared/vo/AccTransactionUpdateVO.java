package com.accounting.shared.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class AccTransactionUpdateVO extends AccTransactionVO implements Serializable {
    private static final long serialVersionUID = 1L;

}

package com.accounting.domain.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "acc_voucher_type")
public class AccVoucherType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_type_id", nullable = false)
    private Integer voucherTypeId;

    @Column(name = "voucher_type_name", nullable = false)
    private String voucherTypeName;

    @Column(name = "abbreviation", nullable = false)
    private String abbreviation;

    @Column(name = "desc")
    private String desc;

}

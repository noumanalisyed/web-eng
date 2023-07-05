package com.stock.product.shared.dto;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer empId;

    private String firstName;

    private Date birthDate;

    private String lastName;

    private String gender;

    private String mobile;

    private String remarks;

    private Integer deleted;

    private String address;

    private Date joiningDate;

    private Integer designationId;

    private Integer departmentId;

    private Integer managerId;

    private String userName;

    private java.util.Date updateTime;

}

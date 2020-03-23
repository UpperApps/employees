package com.upperapps.employees.model;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DeptEmployeesPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "emp_no")
    private Long empNo;

    @NotNull
    @Column(name = "dept_no", length = 4)
    private String deptNo;
}

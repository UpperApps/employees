package com.upperapps.employees.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Data
public class DeptManagerPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "emp_no")
    private Integer empNo;

    @NotNull
    @Column(name = "dept_no", length = 4)
    private String deptNo;
}

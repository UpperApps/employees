package com.upperapps.employees.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
public class SalaryPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "emp_no", nullable = false)
    private Long empNo;

    @NotNull
    @Column(name = "from_date", nullable = false)
    private Date fromDate;
}

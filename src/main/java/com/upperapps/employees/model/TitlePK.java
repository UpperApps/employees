package com.upperapps.employees.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;

@Embeddable
@Data
public class TitlePK implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "emp_no", nullable = false)
    private Long empNo;

    @NotNull
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @NotNull
    @Column(name = "from_date", nullable = false)
    private Date fromDate;
}

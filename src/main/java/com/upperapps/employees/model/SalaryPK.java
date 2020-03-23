package com.upperapps.employees.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

@XmlRootElement
@Data
public class SalaryPK implements Serializable {
    @Id
    @Column(name = "emp_no", nullable = false)
    private Long empNo;

    @Id
    @Column(name = "from_date", nullable = false)
    private Date fromDate;
}

package com.upperapps.employees.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@Entity
@Table(name = "salaries", schema = "employees")
@IdClass(SalaryPK.class)
@XmlRootElement
@Data
public class Salary {
    @Id
    @NotNull
    @Column(name = "emp_no")
    private Long empNo;

    @Id
    @NotNull
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @NotNull
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @NotNull
    @Column(name = "salary")
    private Integer salary;

    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
}

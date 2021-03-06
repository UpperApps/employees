package com.upperapps.employees.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "salaries", schema = "employees")
@XmlRootElement
@IdClass(SalaryPK.class)
@Data
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long empNo;

    @Id
    private Date fromDate;

    @NotNull
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @NotNull
    @Column(name = "salary")
    private Integer salary;

    @JsonBackReference
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
}

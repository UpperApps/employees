package com.upperapps.employees.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@Entity
@Table(name = "dept_emp", schema = "employees")
@IdClass(DeptEmployeesPK.class)
@XmlRootElement
@Data
public class DeptEmployees {
    @Id
    @NotNull
    @Column(name = "emp_no", nullable = false)
    private Long empNo;

    @Id
    @NotNull
    @Column(name = "dept_no", nullable = false)
    private String deptNo;

    @NotNull
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @NotNull
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;

    @JsonManagedReference
    @Column(name = "emp_no")
    private Employee employee;

    @JsonManagedReference
    @Column(name = "dept_no")
    private Department department;

}

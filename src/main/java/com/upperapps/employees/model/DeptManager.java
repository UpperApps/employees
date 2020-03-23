package com.upperapps.employees.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@Entity
@Table(name = "dept_manager", schema = "employees")
@IdClass(DeptManagerPK.class)
@XmlRootElement
@Data
public class DeptManager {
    @Id
    @NotNull
    @Column(name = "emp_no")
    private Long empNo;

    @Id
    @NotNull
    @Column(name = "dept_no", length = 4)
    private String deptNo;

    @NotNull
    @Column(name = "from_date")
    private Date fromDate;

    @NotNull
    @Column(name = "to_date")
    private Date toDate;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", nullable = false)
    private Employee employee;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", nullable = false)
    private Department department;
}

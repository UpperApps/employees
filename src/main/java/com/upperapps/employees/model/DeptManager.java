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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "dept_manager", schema = "employees")
@XmlRootElement
@IdClass(DeptManagerPK.class)
@Data
public class DeptManager implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer empNo;

    @Id
    private String deptNo;

    @NotNull
    @Column(name = "from_date")
    private Date fromDate;

    @NotNull
    @Column(name = "to_date")
    private Date toDate;

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    private Employee employee;

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no", insertable = false, updatable = false)
    private Department department;
}

package com.upperapps.employees.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employees", schema = "employees")
@XmlRootElement
@Data
public class Employee {
    @Id
    @NotNull
    @Column(name = "emp_no")
    private Long empNo;

    @NotNull
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 1, max = 16)
    private String lastName;

    @NotNull
    @Column(name = "gender")
    private GenderType gender;

    @NotNull
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees", fetch = FetchType.LAZY)
    private List<DeptEmployees> deptEmployees;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees", fetch = FetchType.LAZY)
    private List<DeptManager> deptManagers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees", fetch = FetchType.LAZY)
    private List<Salary> salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees", fetch = FetchType.LAZY)
    private List<Title> title;
}

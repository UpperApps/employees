package com.upperapps.employees.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Table(name = "departments", schema = "employees")
@XmlRootElement
@Data
public class Department {
    @Id
    @NotNull
    @Column(name = "dept_no", length = 4)
    private String deptNo;

    @NotNull
    @Column(name = "dept_name", length = 40)
    private String deptName;

    @JsonBackReference
    @OneToMany(mappedBy = "department")
    private List<DeptEmployees> deptEmployees;

    @JsonBackReference
    @OneToMany(mappedBy = "department")
    private List<DeptManager> deptManagers;
}

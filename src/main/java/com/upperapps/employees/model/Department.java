package com.upperapps.employees.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "departments", schema = "employees")
@XmlRootElement
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="deptNo")
@Data
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

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

package com.upperapps.employees.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Data
public class DeptEmployeesPK implements Serializable {

    @Id
    @NotNull
    @Column(name = "emp_no")
    private Long empNo;

    @Id
    @NotNull
    @Column(name = "dept_no", nullable = false, length = 4)
    private String deptNo;
}

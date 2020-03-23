package com.upperapps.employees.model;

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
@Table(name = "titles", schema = "employees")
@IdClass(TitlesPK.class)
@XmlRootElement
@Data
public class Title {
    @Id
    @NotNull
    @Column(name = "emp_no", nullable = false)
    private Long empNo;

    @Id
    @NotNull
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Id
    @NotNull
    @Column(name = "from_date")
    private Date fromDate;

    @NotNull
    @Column(name = "to_date")
    private Date toDate;

    @ManyToOne
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", nullable = false)
    private Employee employee;
}

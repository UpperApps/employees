package com.upperapps.employees.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "titles", schema = "employees")
@XmlRootElement
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="titleId")
@Data
public class Title implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TitlePK titleId;

    @NotNull
    @Column(name = "to_date")
    private Date toDate;

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", referencedColumnName = "emp_no", insertable = false, updatable = false)
    private Employee employee;
}

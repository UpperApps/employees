package com.upperapps.employees.repositories;

import com.upperapps.employees.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}

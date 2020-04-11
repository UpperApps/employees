package com.upperapps.employees.resources;

import com.upperapps.employees.model.Department;
import com.upperapps.employees.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/departments")
public class DepartmentResource {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentResource(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping()
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public Iterable<Department> list(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortBy));

        return departmentRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public Department get(@PathVariable String id) {

        return departmentRepository.findById(id)
                                   .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                                                  "No department found with id " + id));
    }
}

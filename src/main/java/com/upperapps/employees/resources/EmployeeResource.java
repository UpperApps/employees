package com.upperapps.employees.resources;

import com.upperapps.employees.model.Employee;
import com.upperapps.employees.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping(value = "/api/employees", produces = "application/json")
public class EmployeeResource {

    private final EmployeeRepository employeesRepository;

    @Autowired
    public EmployeeResource(EmployeeRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @GetMapping()
    public Iterable<Employee> list(@RequestParam Integer page, @RequestParam Integer size, @RequestParam String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortBy));

        return employeesRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Employee get(@PathVariable String id) {

        return employeesRepository.findById(Long.parseLong(id))
                                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                                                                 "Employee not found with id " + id));
    }
}

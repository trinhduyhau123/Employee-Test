package com.codegym.employeemanager.service;

import com.codegym.employeemanager.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    void delete(Long id);

    Optional<Employee> findById(Long id);
}

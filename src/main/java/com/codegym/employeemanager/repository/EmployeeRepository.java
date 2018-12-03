package com.codegym.employeemanager.repository;

import com.codegym.employeemanager.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}

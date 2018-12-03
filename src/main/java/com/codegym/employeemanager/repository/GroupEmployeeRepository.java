package com.codegym.employeemanager.repository;

import com.codegym.employeemanager.model.Employee;
import com.codegym.employeemanager.model.GroupEmployee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GroupEmployeeRepository extends PagingAndSortingRepository<GroupEmployee, Long> {
}

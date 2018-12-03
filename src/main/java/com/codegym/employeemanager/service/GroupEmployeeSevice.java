package com.codegym.employeemanager.service;

import com.codegym.employeemanager.model.Employee;
import com.codegym.employeemanager.model.GroupEmployee;

import java.util.Optional;

public interface GroupEmployeeSevice {
    Iterable<GroupEmployee> findAll();

    Optional<GroupEmployee> findById(Long id);

    void save(GroupEmployee employee);

    void delete(Long id);
}

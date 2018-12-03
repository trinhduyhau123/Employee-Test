package com.codegym.employeemanager.service.impl;

import com.codegym.employeemanager.model.Employee;
import com.codegym.employeemanager.model.GroupEmployee;
import com.codegym.employeemanager.repository.GroupEmployeeRepository;
import com.codegym.employeemanager.service.GroupEmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GroupEmployeeServiceImpl implements GroupEmployeeSevice {

    @Autowired
    private GroupEmployeeRepository groupEmployeeRepository;

    @Override
    public Iterable<GroupEmployee> findAll() {
        return groupEmployeeRepository.findAll();
    }

    @Override
    public Optional<GroupEmployee> findById(Long id) {
        return groupEmployeeRepository.findById(id);
    }

    @Override
    public void save(GroupEmployee employee) {
        groupEmployeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        groupEmployeeRepository.deleteById(id);
    }
}

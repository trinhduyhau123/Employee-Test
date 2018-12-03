package com.codegym.employeemanager.controller;

import com.codegym.employeemanager.model.Employee;
import com.codegym.employeemanager.model.GroupEmployee;
import com.codegym.employeemanager.service.EmployeeService;
import com.codegym.employeemanager.service.GroupEmployeeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class GroupEmployeeController {
    @Autowired
    private GroupEmployeeSevice groupEmployeeSevice;

    @GetMapping("list")
    public ModelAndView home() {
        Iterable<GroupEmployee> groupEmployees = groupEmployeeSevice.findAll();
        return new ModelAndView("group/list", "groupEmployees", groupEmployees);
    }

    @GetMapping("create-groupEmployee")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("group/create");
        modelAndView.addObject("groupEmployee", new GroupEmployee());
        return modelAndView;
    }

    @PostMapping("create-groupEmployee")
    public ModelAndView createEmployee(@Validated @ModelAttribute("groupEmployee") GroupEmployee groupEmployee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("group/create");
        } else {
            groupEmployeeSevice.save(groupEmployee);
            ModelAndView modelAndView = new ModelAndView("group/create");
            modelAndView.addObject("groupEmployee", new GroupEmployee());
            modelAndView.addObject("message", "Create successful");
            return modelAndView;
        }
    }

    @GetMapping("edit-groupEmployee/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<GroupEmployee> groupEmployee= groupEmployeeSevice.findById(id);
        ModelAndView modelAndView = new ModelAndView("group/edit");
        modelAndView.addObject("groupEmployee", groupEmployee);
        return modelAndView;
    }

    @PostMapping("edit-groupEmployee")
    public ModelAndView editEmployee(@ModelAttribute("groupEmployee") GroupEmployee groupEmployee) {
        groupEmployeeSevice.save(groupEmployee);
        ModelAndView modelAndView = new ModelAndView("groupEmployee/edit");
        modelAndView.addObject("groupEmployee", groupEmployee);
        modelAndView.addObject("message", "Edit sccessfull");
        return modelAndView;
    }

    @GetMapping("delete-groupEmployee/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<GroupEmployee> groupEmployee = groupEmployeeSevice.findById(id);
        ModelAndView modelAndView = new ModelAndView("group/delete");
        modelAndView.addObject("groupEmployee", groupEmployee);
        return modelAndView;
    }

    @PostMapping("delete-groupEmployee")
    public ModelAndView deleteCustomer(@ModelAttribute("groupEmployee") GroupEmployee groupEmployee){
        groupEmployeeSevice.delete(groupEmployee.getId());
        ModelAndView modelAndView = new ModelAndView("group/delete");
        modelAndView.addObject("groupEmployee", groupEmployee);
        modelAndView.addObject("message", "Delete sccessfull");
        return modelAndView;
    }
}


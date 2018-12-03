package com.codegym.employeemanager.controller;

import com.codegym.employeemanager.model.Employee;
import com.codegym.employeemanager.service.EmployeeService;
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
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("list")
    public ModelAndView home(Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        return new ModelAndView("employee/list", "employees", employees);
    }

    @GetMapping("create-employee")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("create-employee")
    public ModelAndView createEmployee(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("employee/create");
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("employee/create");
            modelAndView.addObject("employee", new Employee());
            modelAndView.addObject("message", "Create successful");
            return modelAndView;
        }
    }

    @GetMapping("edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Employee> employee= employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("edit-employee")
    public ModelAndView editEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "Edit sccessfull");
        return modelAndView;
    }

    @GetMapping("delete-employee/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Employee> employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/delete");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("delete-employee")
    public ModelAndView deleteCustomer(@ModelAttribute("employee") Employee employee){
        employeeService.delete(employee.getId());
        ModelAndView modelAndView = new ModelAndView("employee/delete");
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("message", "Delete sccessfull");
        return modelAndView;
    }
}


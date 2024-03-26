package com.ghulam.employee.service;

import com.ghulam.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee read(Long employeeId);
    Employee update(Long employeeId, Employee employee);
    void delete(Long employeeId);

    List<Employee> allEmployees();
}

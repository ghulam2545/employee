package com.ghulam.employee.service.impl;

import com.ghulam.employee.model.Employee;
import com.ghulam.employee.repository.EmployeeRepository;
import com.ghulam.employee.service.EmployeeService;
import com.ghulam.employee.utils.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        final Long id = IdGenerator.next();
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee read(Long employeeId) {
        try {
            return employeeRepository.findById(employeeId).orElseThrow();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee update(Long employeeId, Employee employee) {
        try {
            Employee emp = employeeRepository.findById(employeeId).orElseThrow();

            emp.setFirstName(emp.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setEmail(employee.getEmail());
            emp.setDepartment(employee.getDepartment());

            return employeeRepository.save(emp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long employeeId) {
        try {
            boolean found = employeeRepository.existsById(employeeId);
            if(found) employeeRepository.deleteById(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }
}

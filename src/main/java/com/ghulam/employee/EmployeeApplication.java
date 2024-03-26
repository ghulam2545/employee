package com.ghulam.employee;

import com.ghulam.employee.enums.Department;
import com.ghulam.employee.model.Employee;
import com.ghulam.employee.repository.EmployeeRepository;
import com.ghulam.employee.utils.IdGenerator;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmployeeApplication implements ApplicationRunner {

	private final EmployeeRepository employeeRepository;

    public EmployeeApplication(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Employee> employees = List.of(
				new Employee(IdGenerator.next(), "Jamal", "Hashim", "jamal@gmail.com", Department.HEALTH),
				new Employee(IdGenerator.next(), "Nehal", "Hashim", "nehal@gmail.com", Department.SPORT),
				new Employee(IdGenerator.next(), "Belal", "Hashim", "belal@gmail.com", Department.TECHNOLOGY)
		);

		employeeRepository.saveAll(employees);
	}
}

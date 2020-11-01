package com.brick.productivity.brickmanagement.servie;

import com.brick.productivity.brickmanagement.exception.ResourceNotFoundException;
import com.brick.productivity.brickmanagement.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(UUID employeeId) throws ResourceNotFoundException;

    Employee createEmployee(Employee employee);

    Employee updateEmployee(UUID employeeId,Employee employeeDetails) throws ResourceNotFoundException;

    Map<String, Boolean> deleteEmployee(UUID employeeId) throws ResourceNotFoundException;
}

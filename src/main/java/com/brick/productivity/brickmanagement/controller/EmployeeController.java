package com.brick.productivity.brickmanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.brick.productivity.brickmanagement.exception.ResourceNotFoundException;
import com.brick.productivity.brickmanagement.model.Employee;
import com.brick.productivity.brickmanagement.repository.EmployeeRepository;
import com.brick.productivity.brickmanagement.servie.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${brick-management.publicPrefix}/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Get All Employee")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Get Employee Id")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") UUID employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(httpMethod = "POST", value = "Create Employee")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(httpMethod = "PUT", value = "Update Employee By Id")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") UUID employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee updatedEmployee = employeeService.updateEmployee(employeeId , employeeDetails);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(httpMethod = "DELETE", value = "Delete Employee By Id")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") UUID employeeId)
			throws ResourceNotFoundException {
		return  employeeService.deleteEmployee(employeeId);
	}
}

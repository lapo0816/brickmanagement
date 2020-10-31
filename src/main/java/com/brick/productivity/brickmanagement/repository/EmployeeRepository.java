package com.brick.productivity.brickmanagement.repository;

import com.brick.productivity.brickmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

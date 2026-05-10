package com.example.ems.repository;

import com.example.ems.entity.Employee;
import com.example.ems.entity.Employee.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    List<Employee> findByDepartment(String department);
    List<Employee> findByStatus(EmployeeStatus status);
}
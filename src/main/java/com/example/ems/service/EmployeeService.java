package com.example.ems.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found: " + id));
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getByDepartment(String department) {
    return repository.findByDepartment(department);
    }

    public List<Employee> getSortedEmployees(String field, String order) {
    Sort sort = order.equalsIgnoreCase("desc") 
        ? Sort.by(field).descending() 
        : Sort.by(field).ascending();
    return repository.findAll(sort);
}

public Page<Employee> getPaginatedEmployees(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return repository.findAll(pageable);
}

    public Employee update(Long id, Employee updated) {
        Employee existing = getById(id);
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        existing.setJobTitle(updated.getJobTitle());
        existing.setSalary(updated.getSalary());
        existing.setHireDate(updated.getHireDate());
        existing.setStatus(updated.getStatus());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
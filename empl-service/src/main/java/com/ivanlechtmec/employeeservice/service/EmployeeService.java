package com.ivanlechtmec.employeeservice.service;

import com.ivanlechtmec.employeeservice.exceptions.EmployeeNotFoundException;
import com.ivanlechtmec.employeeservice.mapper.EmployeeDTO;
import com.ivanlechtmec.employeeservice.mapper.EmployeeMapper;
import com.ivanlechtmec.employeeservice.model.Employee;
import com.ivanlechtmec.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeMapper mapper;
    private final EmployeeRepository employeeRepository;
    @Transactional
    public List<EmployeeDTO> findAll(){
        return employeeRepository.findAll().stream().map(mapper::toDTO).toList();
    }
    @Transactional
    public Long createEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee.getId();
    }

    @Transactional
    public EmployeeDTO changeSalary(Long id, BigDecimal newSalary){
        Employee emp = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(HttpStatus.NOT_FOUND,"Employee not found"));
        emp.setSalary(newSalary);
        return mapper.toDTO(emp);
    }
    @Transactional
    public void deleteEmployee(Long id){
        Employee emp = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(HttpStatus.NOT_FOUND,"Employee not found"));
        employeeRepository.delete(emp);

    }
}

package com.ivanlechtmec.employeeservice.controller;

import com.ivanlechtmec.employeeservice.mapper.EmployeeDTO;
import com.ivanlechtmec.employeeservice.mapper.EmployeeMapper;
import com.ivanlechtmec.employeeservice.model.Employee;
import com.ivanlechtmec.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Long> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(HttpStatus.OK).body(service.createEmployee(employee));
    }
    @PatchMapping("/{id}/salary")
    public ResponseEntity<EmployeeDTO> changeSalary(@PathVariable Long id, @RequestBody BigDecimal newSalary){
        return ResponseEntity.status(HttpStatus.OK).body(service.changeSalary(id, newSalary));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

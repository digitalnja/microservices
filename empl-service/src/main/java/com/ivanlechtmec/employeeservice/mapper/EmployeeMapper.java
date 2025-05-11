package com.ivanlechtmec.employeeservice.mapper;

import com.ivanlechtmec.employeeservice.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "salary", target = "salary")
    EmployeeDTO toDTO(Employee employee);
    Employee toEntity(EmployeeDTO employeeDTO);
}

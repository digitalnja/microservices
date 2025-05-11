package com.ivanlechtmec.employeeservice.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeNotFoundException extends ResponseStatusException {


    public EmployeeNotFoundException(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}

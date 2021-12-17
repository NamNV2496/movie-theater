package com.movie.theater.service;

import com.movie.theater.model.entity.Employee;

public interface EmployeeInternalService {
    void create(Employee employee);
    String getEmployeeId(String accountId);
}

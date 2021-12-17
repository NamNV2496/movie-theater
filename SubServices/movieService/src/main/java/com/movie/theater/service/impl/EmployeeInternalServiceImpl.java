package com.movie.theater.service.impl;

import com.movie.theater.exception.AppException;
import com.movie.theater.model.common.ErrorCode;
import com.movie.theater.model.entity.Employee;
import com.movie.theater.model.entity.Member;
import com.movie.theater.repository.EmployeeRepository;
import com.movie.theater.service.EmployeeInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeInternalServiceImpl implements EmployeeInternalService {
    private final EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public String getEmployeeId(String accountId) {
        Employee employee = employeeRepository.findEmployeeByAccountId(accountId).orElseThrow(()
                -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));

        return employee.getId();
    }
}

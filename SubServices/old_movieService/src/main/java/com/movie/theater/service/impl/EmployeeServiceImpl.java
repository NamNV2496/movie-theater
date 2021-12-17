package com.movie.theater.service.impl;

import com.movie.theater.exception.AppException;
import com.movie.theater.model.common.ErrorCode;
import com.movie.theater.model.entity.Account;
import com.movie.theater.model.entity.Employee;
import com.movie.theater.model.response.AccountEmployeeResponse;
import com.movie.theater.repository.EmployeeRepository;
import com.movie.theater.service.AccountInternalService;
import com.movie.theater.service.EmployeeService;
import com.movie.theater.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;
    private final AccountInternalService accountInternalService;
    private final AccountMapper mapper;

    @Override
    public List<AccountEmployeeResponse> get() {
        List<Employee> employeeList = repository.findAll();

        List<Account> accountList = accountInternalService.findEmployeeByActiveAccount();

        List<AccountEmployeeResponse> accountEmployeeResponses = new ArrayList<>();

        for (Employee e: employeeList) {
            for(Account account : accountList){
                if(e.getAccountId().equals(account.getAccountId())){
                    accountEmployeeResponses.add(mapper.mapEmployeeResponse(e.getId(), account));
                }
            }
        }

        return accountEmployeeResponses;

    }

    @Override
    public AccountEmployeeResponse getEmployeeByAccountName(String username) {
        Account account = accountInternalService.findAccountByName(username);

        Employee employee = repository.findEmployeeByAccountId(account.getAccountId()).orElseThrow(()
                -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));

        return mapper.mapEmployeeResponse(employee.getId(), account);
    }

    @Override
    public void deleteEmployee(String employeeId) {
        Employee employee = repository.findById(employeeId).orElseThrow(()
                -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));

        accountInternalService.deleteAccountById(employee.getAccountId());
    }


}

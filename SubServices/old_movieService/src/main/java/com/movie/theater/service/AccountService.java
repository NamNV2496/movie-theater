package com.movie.theater.service;

import com.movie.theater.model.request.AccountRequest;
import com.movie.theater.model.response.AccountMemberResponse;
import com.movie.theater.model.response.AccountEmployeeResponse;

public interface AccountService {

    void createMember(AccountRequest request);

    void createEmployee(AccountRequest request);

    AccountMemberResponse editMember(String accountId, AccountRequest accountRequest);

    AccountEmployeeResponse editEmployee(String employeeId, AccountRequest accountRequest);
}

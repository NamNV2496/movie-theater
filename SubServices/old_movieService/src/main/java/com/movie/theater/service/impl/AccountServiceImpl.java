package com.movie.theater.service.impl;

import com.movie.theater.exception.AppException;
import com.movie.theater.model.common.ErrorCode;
import com.movie.theater.model.entity.Account;
import com.movie.theater.model.entity.Employee;
import com.movie.theater.model.entity.Member;
import com.movie.theater.model.request.AccountRequest;
import com.movie.theater.model.response.AccountEmployeeResponse;
import com.movie.theater.model.response.AccountMemberResponse;
import com.movie.theater.repository.AccountRepository;
import com.movie.theater.service.AccountService;
import com.movie.theater.service.EmployeeInternalService;
import com.movie.theater.service.MemberInternalService;
import com.movie.theater.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;
    private final MemberInternalService memberInternalService;
    private final EmployeeInternalService employeeInternalService;

    @Override
    public void createMember(AccountRequest request) {
        if(accountRepository.findAccountByUsername(request.getAccount()).isPresent()){
            throw new AppException(ErrorCode.ACCOUNT_ALREADY_EXISTS);
        }

        Account account = mapper.mapMemberRequest(request);
        accountRepository.save(account);

        Member member = new Member();
        member.setAccountId(account.getAccountId());
        memberInternalService.create(member);

    }

    @Override
    public void createEmployee(AccountRequest request) {
        if(accountRepository.findAccountByUsername(request.getAccount()).isPresent()){
            throw new AppException(ErrorCode.ACCOUNT_ALREADY_EXISTS);
        }

        Account account = mapper.mapEmployeeRequest(request);
        accountRepository.save(account);

        Employee employee = new Employee();
        employee.setAccountId(account.getAccountId());
        employeeInternalService.create(employee);
    }

    @Override
    public AccountMemberResponse editMember(String accountId, AccountRequest accountRequest) {
        String memberId = memberInternalService.getMemberId(accountId);

        Account account = accountRepository.findById(accountId).orElseThrow(()
                -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));

        account = mapper.map(account, accountRequest);

        accountRepository.save(account);

        return mapper.mapMemberResponse(memberId, account);
    }

    @Override
    public AccountEmployeeResponse editEmployee(String accountId, AccountRequest accountRequest) {
        String employeeId = employeeInternalService.getEmployeeId(accountId);

        Account account = accountRepository.findById(accountId).orElseThrow(()
                -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));

        account = mapper.map(account, accountRequest);

        accountRepository.save(account);

        return mapper.mapEmployeeResponse(employeeId, account);
    }


}

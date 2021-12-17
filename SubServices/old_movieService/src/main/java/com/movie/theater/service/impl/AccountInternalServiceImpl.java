package com.movie.theater.service.impl;

import com.movie.theater.exception.AppException;
import com.movie.theater.model.common.ErrorCode;
import com.movie.theater.model.entity.Account;
import com.movie.theater.repository.AccountRepository;
import com.movie.theater.service.AccountInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountInternalServiceImpl implements AccountInternalService {
    private final AccountRepository repository;

    @Override
    public List<Account> findEmployeeByActiveAccount() {
        return repository.findAccountByActive(1);
    }

    @Override
    public List<Account> findAccount() {
        return repository.findAll();
    }

    @Override
    public Account findAccountById(String accountId) {
        return repository.findById(accountId).orElseThrow(()
                -> new AppException(ErrorCode.ACCOUNT_NOT_FOUND));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAccountById(String accountId) {
        repository.deleteAccountById(accountId);
    }

    @Override
    public Account findAccountByName(String username) {
        return repository.findAccountByUsername(username).orElse(new Account());
    }
}

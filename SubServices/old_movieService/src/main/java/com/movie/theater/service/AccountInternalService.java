package com.movie.theater.service;

import com.movie.theater.model.entity.Account;

import java.util.List;

public interface AccountInternalService {
    List<Account> findEmployeeByActiveAccount();
    List<Account> findAccount();
    Account findAccountById(String accountId);
    void deleteAccountById(String accoutnId);
    Account findAccountByName(String username);
}

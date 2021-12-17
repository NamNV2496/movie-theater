package com.movie.theater.repository;

import com.movie.theater.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findAccountByUsername(String username);

    @Query(value = "select a from Account a where a.status = ?1 ")
    List<Account> findAccountByActive(int status);

    @Query(value = "update Account a set a.status = 0 where a.accountId = ?1 and a.status = 1 ")
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void deleteAccountById(String accountId);
}

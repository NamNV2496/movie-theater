package com.authorization_service.repository;

import com.authorization_service.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account a where a.username=?1")
    Optional<Account> findByName(String usename);
}

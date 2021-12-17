package com.movie.theater.service.mapper;

import com.movie.theater.model.entity.Account;
import com.movie.theater.model.request.AccountRequest;
import com.movie.theater.model.response.AccountEmployeeResponse;
import com.movie.theater.model.response.AccountMemberResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    private final PasswordEncoder passwordEncoder;

    public AccountMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * map accountRequest to Member Account
     * @return account
     */
    public Account mapMemberRequest(AccountRequest request){
        Account account = new Account();

        account.setStatus(1);
        account.setRoleId(1);
        account.setUsername(request.getAccount());
        account.setAddress(request.getAddress());
        account.setEmail(request.getEmail());
        account.setGender(request.getGender());
        account.setFullName(request.getFullName());
        account.setDateOfBirth(request.getDateOfBirth());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setIdentityCard(request.getIdentityCard());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setImage(request.getImage());

        return account;
    }

    /**
     * accountRequest to Employee Account
     * @return account
     */
    public Account mapEmployeeRequest(AccountRequest request){
        Account account = new Account();

        account.setStatus(1);
        account.setRoleId(2);
        account.setUsername(request.getAccount());
        account.setAddress(request.getAddress());
        account.setEmail(request.getEmail());
        account.setGender(request.getGender());
        account.setFullName(request.getFullName());
        account.setDateOfBirth(request.getDateOfBirth());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setIdentityCard(request.getIdentityCard());
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        account.setImage(request.getImage());

        return account;
    }

    /**
     * map update account
     * @return account update
     */
    public Account map(Account account, AccountRequest request){

        account.setUsername(request.getAccount());
        account.setAddress(request.getAddress());
        account.setEmail(request.getEmail());
        account.setGender(request.getGender());
        account.setFullName(request.getFullName());
        account.setDateOfBirth(request.getDateOfBirth());
        account.setPhoneNumber(request.getPhoneNumber());
        account.setIdentityCard(request.getIdentityCard());
        account.setPassword(request.getPassword());
        account.setImage(request.getImage());

        return account;
    }

    /**
     * map member response
     * @return AccountMemberResponse
     */
    public AccountMemberResponse mapMemberResponse(String memberId, Account account){
        AccountMemberResponse accountMemberResponse = new AccountMemberResponse();

        accountMemberResponse.setAccountId(account.getAccountId());
        accountMemberResponse.setAccount(account.getUsername());
        accountMemberResponse.setAddress(account.getAddress());
        accountMemberResponse.setEmail(account.getEmail());
        accountMemberResponse.setGender(account.getGender());
        accountMemberResponse.setFullName(account.getFullName());
        accountMemberResponse.setDateOfBirth(account.getDateOfBirth());
        accountMemberResponse.setPhoneNumber(account.getPhoneNumber());
        accountMemberResponse.setIdentityCard(account.getIdentityCard());
        accountMemberResponse.setPassword(account.getPassword());
        accountMemberResponse.setImage(account.getImage());
        accountMemberResponse.setMemberId(memberId);

        return accountMemberResponse;
    }

    /**
     * map Employee response
     * @return AccountEmployeeResponse
     */
    public AccountEmployeeResponse mapEmployeeResponse(String employeeId, Account account){
        AccountEmployeeResponse accountEmployeeResponse = new AccountEmployeeResponse();

        accountEmployeeResponse.setAccountId(account.getAccountId());
        accountEmployeeResponse.setAccount(account.getUsername());
        accountEmployeeResponse.setAddress(account.getAddress());
        accountEmployeeResponse.setEmail(account.getEmail());
        accountEmployeeResponse.setGender(account.getGender());
        accountEmployeeResponse.setFullName(account.getFullName());
        accountEmployeeResponse.setDateOfBirth(account.getDateOfBirth());
        accountEmployeeResponse.setPhoneNumber(account.getPhoneNumber());
        accountEmployeeResponse.setIdentityCard(account.getIdentityCard());
        accountEmployeeResponse.setPassword(account.getPassword());
        accountEmployeeResponse.setImage(account.getImage());
        accountEmployeeResponse.setEmployeeId(employeeId);

        return accountEmployeeResponse;
    }
}

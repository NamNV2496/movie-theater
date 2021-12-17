package com.movie.theater.service;

import com.movie.theater.model.response.AccountMemberResponse;

import java.util.List;

public interface MemberService {
    List<AccountMemberResponse> getAll();

    AccountMemberResponse get(String memberId);

    AccountMemberResponse getMemberByAccountName(String username);
}

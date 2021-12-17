package com.movie.theater.service;

import com.movie.theater.model.entity.Member;

public interface MemberInternalService {
    void create(Member member);
    String getMemberId(String accountId);
}

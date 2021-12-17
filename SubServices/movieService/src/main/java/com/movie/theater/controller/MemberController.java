package com.movie.theater.controller;

import com.movie.theater.model.common.SystemResponse;
import com.movie.theater.model.response.AccountEmployeeResponse;
import com.movie.theater.model.response.AccountMemberResponse;
import com.movie.theater.model.response.Response;
import com.movie.theater.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/get-all")
    public ResponseEntity<SystemResponse<List<AccountMemberResponse>>> getAll(){
        return Response.ok(memberService.getAll());
    }

    @GetMapping("/get-member")
    public ResponseEntity<SystemResponse<AccountMemberResponse>> getById(@RequestParam @NotBlank String memberId){
        return Response.ok(memberService.get(memberId));
    }

    @GetMapping("/get-by-username")
    public ResponseEntity<SystemResponse<AccountMemberResponse>> getEmployeeByAccountName(@RequestParam String username){
        return Response.ok(memberService.getMemberByAccountName(username));
    }
}

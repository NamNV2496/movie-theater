//package com.movie.theater.controller;
//
//import com.movie.theater.model.common.SystemResponse;
//import com.movie.theater.model.request.AccountRequest;
//import com.movie.theater.model.response.AccountEmployeeResponse;
//import com.movie.theater.model.response.AccountMemberResponse;
//import com.movie.theater.model.response.Response;
//import com.movie.theater.service.AccountService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotBlank;
//
//@RestController
//@RequestMapping("/account")
//@RequiredArgsConstructor
//public class AccountController {
//    private final AccountService accountService;
//
//    @PostMapping("/register/member")
//    public ResponseEntity<SystemResponse<Object>> createMember(@Valid @RequestBody AccountRequest request){
//         accountService.createMember(request);
//
//         return Response.ok();
//    }
//
//    @PostMapping("/register/employee")
//    public ResponseEntity<SystemResponse<Object>> createEmployee(@Valid @RequestBody AccountRequest request){
//        accountService.createEmployee(request);
//
//        return Response.ok();
//    }
//
//    @PutMapping("/edit/member")
//    public ResponseEntity<SystemResponse<AccountMemberResponse>> editMember
//            (@RequestParam @NotBlank String accountId, @Valid @RequestBody AccountRequest accountRequest){
//
//        return Response.ok(accountService.editMember(accountId, accountRequest));
//    }
//
//    @PutMapping("/edit/employee")
//    public ResponseEntity<SystemResponse<AccountEmployeeResponse>> editEmployee
//            (@RequestParam @NotBlank String employeeId, @Valid @RequestBody AccountRequest accountRequest){
//
//        return Response.ok(accountService.editEmployee(employeeId, accountRequest));
//    }
//
//}

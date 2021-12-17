package com.movie.theater.controller;

import com.movie.theater.model.common.SystemResponse;
import com.movie.theater.model.response.AccountEmployeeResponse;
import com.movie.theater.model.response.Response;
import com.movie.theater.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/get-all/active")
    public ResponseEntity<SystemResponse<List<AccountEmployeeResponse>>> getAllEmployee(){
       return Response.ok(employeeService.get());
    }

    @GetMapping("/get-by-username")
    public ResponseEntity<SystemResponse<AccountEmployeeResponse>> getEmployeeByAccountName(@RequestParam String username){
       return Response.ok(employeeService.getEmployeeByAccountName(username));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<SystemResponse<Object>> deleteEmployee(@RequestParam @NotBlank String employeeId){
        employeeService.deleteEmployee(employeeId);
        return Response.ok();
    }


}

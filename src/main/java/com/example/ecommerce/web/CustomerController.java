package com.example.ecommerce.web;

import com.example.ecommerce.domain.dto.SignupResponse;
import com.example.ecommerce.service.CustomerService;
import com.example.ecommerce.domain.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SignupResponse> signup(@Validated @RequestBody SignupRequest request) {
        SignupResponse signupResponse = customerService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(signupResponse);
    }
}

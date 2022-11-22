package com.example.ecommerce.web;

import com.example.ecommerce.domain.dto.SignupResponseDto;
import com.example.ecommerce.service.CustomerService;
import com.example.ecommerce.domain.dto.SignupRequestDto;
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
    public ResponseEntity<SignupResponseDto> signup(@Validated @RequestBody SignupRequestDto request) {
        SignupResponseDto signupResponse = customerService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(signupResponse);
    }
}

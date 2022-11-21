package com.example.ecommerce.web;

import com.example.ecommerce.global.SuccessResponse;
import com.example.ecommerce.service.CustomerService;
import com.example.ecommerce.web.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("")
    public String Hello() {
        return "Hello world";
    }

    @PostMapping("/sign-up")
    public SuccessResponse signup(@Validated @RequestBody SignupRequest request) {
        customerService.signup(request);
        return SuccessResponse.sendWithoutObject(HttpStatus.CREATED, "회원가입 완료");
    }
}

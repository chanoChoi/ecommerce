package com.example.ecommerce.service;

import com.example.ecommerce.domain.entities.CustomerEntity;
import com.example.ecommerce.domain.dto.SignupResponseDto;
import com.example.ecommerce.exceptions.SignupException;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.domain.dto.SignupRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    public SignupResponseDto signup(SignupRequestDto request) {
        Assert.notNull(request, "SignupRequestDto must be not null");

        if (this.existEmail(request.getEmail())) {
            throw new SignupException("Already exist Email");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        CustomerEntity customer = CustomerEntity.of(request, encodedPassword);

        return SignupResponseDto.convertToSignupResponse(customerRepository.save(customer));
    }

    private boolean existEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}

package com.example.ecommerce.service;

import com.example.ecommerce.domain.Customer;
import com.example.ecommerce.repository.CustomerRepository;
import com.example.ecommerce.web.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    public void signup(SignupRequest request) {
        if (this.existEmail(request.getEmail())) {
            throw new IllegalArgumentException("Already exist Email");
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Customer customer = Customer.of(request, encodedPassword);
        customerRepository.save(customer);
    }

    private boolean existEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}

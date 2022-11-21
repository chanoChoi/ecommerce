package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupResponse {
    private String name;
    private String phoneNumber;
    private String email;
    private boolean marketingYN;

    public static SignupResponse convertToSignupResponse(Customer savedCustomer) {
        return SignupResponse.builder()
                .name(savedCustomer.getName())
                .email(savedCustomer.getEmail())
                .phoneNumber(savedCustomer.getPhoneNumber())
                .marketingYN(savedCustomer.isMarketingYN())
                .build();
    }
}

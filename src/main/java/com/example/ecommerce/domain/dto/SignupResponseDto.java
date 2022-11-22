package com.example.ecommerce.domain.dto;

import com.example.ecommerce.domain.entities.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupResponseDto {
    private String name;
    private String phoneNumber;
    private String email;
    private boolean marketingYN;

    public static SignupResponseDto convertToSignupResponse(CustomerEntity savedCustomer) {
        return SignupResponseDto.builder()
                .name(savedCustomer.getName())
                .email(savedCustomer.getEmail())
                .phoneNumber(savedCustomer.getPhoneNumber())
                .marketingYN(savedCustomer.isMarketingYN())
                .build();
    }
}

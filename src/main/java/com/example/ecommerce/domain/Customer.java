package com.example.ecommerce.domain;


import com.example.ecommerce.domain.dto.SignupRequest;
import com.example.ecommerce.global.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private boolean marketingYN;

    @OneToOne(cascade = CascadeType.ALL)
    private Membership membership;

    public static Customer of(SignupRequest request, String encodedPassword) {
        return Customer.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .password(encodedPassword)
                .marketingYN(request.isMarketingYN())
                .membership(Membership.makeDefaultMember())
                .build();
    }
}

package com.example.ecommerce.domain.entities;


import com.example.ecommerce.domain.dto.SignupRequestDto;
import com.example.ecommerce.global.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class CustomerEntity extends BaseEntity {
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
    private MembershipEntity membership;

    public static CustomerEntity of(SignupRequestDto request, String encodedPassword) {
        return CustomerEntity.builder()
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .password(encodedPassword)
                .marketingYN(request.isMarketingYN())
                .membership(MembershipEntity.makeDefaultMember())
                .build();
    }
}

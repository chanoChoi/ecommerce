package com.example.ecommerce.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MembershipEnum {
    MEMBER(0f),
    WOW_MEMBER(0.2f);

    private final float discountRate;
}

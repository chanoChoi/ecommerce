package com.example.ecommerce.domain.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;
    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$")
    private String email;
    @NotNull
    private String password;
    private boolean marketingYN;
}

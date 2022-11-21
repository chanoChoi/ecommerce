package com.example.ecommerce.web.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
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

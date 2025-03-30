package com.mh.enterprise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    private String fullName;

    @Email(message = "Email should be valid")
    private String email;

    private String department;

    private String position;

    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private Set<String> roles;

    private Boolean enabled;
}
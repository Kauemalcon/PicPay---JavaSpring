package com.example.picpay.dtos;

import com.example.picpay.domain.user.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstName, String lastName, String document, String email, UserType userType, BigDecimal balance, String passward) {
}

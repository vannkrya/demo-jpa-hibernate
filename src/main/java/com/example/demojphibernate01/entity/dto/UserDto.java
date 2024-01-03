package com.example.demojphibernate01.entity.dto;

import com.example.demojphibernate01.entity.model.Address;

public record UserDto(
        Long id,
        String username,
        Address address
) {
}

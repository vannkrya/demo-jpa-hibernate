package com.example.demojphibernate01.request;


public record UserRequest(
        String username,
        AddressRequest addressRequest
) {
}

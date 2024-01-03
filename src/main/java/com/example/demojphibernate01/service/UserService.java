package com.example.demojphibernate01.service;

import com.example.demojphibernate01.entity.dto.UserDto;
import com.example.demojphibernate01.request.UserRequest;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto create(UserRequest userRequest);
}

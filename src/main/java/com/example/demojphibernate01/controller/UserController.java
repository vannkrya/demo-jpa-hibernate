package com.example.demojphibernate01.controller;

import com.example.demojphibernate01.entity.dto.UserDto;
import com.example.demojphibernate01.request.UserRequest;
import com.example.demojphibernate01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get-all")
    public List<UserDto> getAll() {
        List<UserDto> userDtoList = userService.getAll();
        return userDtoList;
    }

    @PostMapping("/create")
    public UserDto create(@RequestBody UserRequest userRequest) {
        UserDto userDto = userService.create(userRequest);
        return userDto;
    }

}

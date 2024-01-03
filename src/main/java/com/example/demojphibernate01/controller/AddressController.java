package com.example.demojphibernate01.controller;

import com.example.demojphibernate01.entity.dto.AddressDto;
import com.example.demojphibernate01.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get-all")
    public List<AddressDto> getAll() {
        List<AddressDto> addressDtoList = addressService.getAll();
        return addressDtoList;
    }

}

package com.example.demojphibernate01.service;

import com.example.demojphibernate01.entity.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> getAll();
}

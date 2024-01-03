package com.example.demojphibernate01.service.implementation;

import com.example.demojphibernate01.entity.dto.AddressDto;
import com.example.demojphibernate01.entity.model.Address;
import com.example.demojphibernate01.repository.AddressRepository;
import com.example.demojphibernate01.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public AddressDto convertToDto(Address address) {
        return new AddressDto(
                address.getId(),
                address.getStreet(),
                address.getCity()
        );
    }

}

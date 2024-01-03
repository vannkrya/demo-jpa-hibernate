package com.example.demojphibernate01.service.implementation;

import com.example.demojphibernate01.entity.dto.UserDto;
import com.example.demojphibernate01.entity.model.Address;
import com.example.demojphibernate01.entity.model.User;
import com.example.demojphibernate01.repository.UserRepository;
import com.example.demojphibernate01.request.AddressRequest;
import com.example.demojphibernate01.request.UserRequest;
import com.example.demojphibernate01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto create(UserRequest userRequest) {
        AddressRequest addressRequest = userRequest.addressRequest();

        Address address = new Address();
        address.setCity(addressRequest.city());
        address.setStreet(addressRequest.street());

        User user = new User();
        user.setUsername(userRequest.username());
        user.setAddress(address);

        User saveUser = userRepository.save(user);

        return convertToDto(saveUser);
    }

    public UserDto convertToDto(User user) {
        return new UserDto(
          user.getId(),
          user.getUsername(),
          user.getAddress()
        );
    }

}

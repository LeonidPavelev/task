package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.data.entity.PhoneEntity;
import org.example.data.entity.UserEntity;
import org.example.data.entity.UserPhonesEntity;
import org.example.data.repository.PhoneRepository;
import org.example.data.repository.UserPhoneRepository;
import org.example.data.repository.UserRepository;
import org.example.domain.PhoneDto;
import org.example.domain.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PhoneRepository phoneRepository;
    private final UserPhoneRepository userPhoneRepository;

    @Transactional
    public UUID saveUser (UserDto userDto){
       return userRepository.save(UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .secondName(userDto.getSecondName())
                .address(userDto.getAddress())
                .position(userDto.getPosition())
                .build()).getId();
    }
    @Transactional
    public UUID savePhone(PhoneDto phoneDto){
        return phoneRepository.save(PhoneEntity.builder()
                .number(phoneDto.getNumber())
                .type(phoneDto.getType())
                .build()).getId();
    }
    @Transactional
    public void bind (String firstName, String lastName, String secondName,  String phoneNumber){
        UserEntity userEntity = userRepository.findByFirstNameAndSecondNameAndLastName(firstName, secondName, lastName).orElseThrow();
        PhoneEntity phoneEntity = phoneRepository.findByNumber(phoneNumber).orElseThrow();
        userPhoneRepository.save(UserPhonesEntity.builder()
            .user(userEntity)
            .phone(phoneEntity)
            .build());
    }
}

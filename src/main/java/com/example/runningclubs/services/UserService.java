package com.example.runningclubs.services;

import com.example.runningclubs.DTO.RegistrationDTO;
import com.example.runningclubs.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDTO registrationDTO);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}

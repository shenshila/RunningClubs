package com.example.runningclubs.services.impl;

import com.example.runningclubs.DTO.RegistrationDTO;
import com.example.runningclubs.models.Role;
import com.example.runningclubs.models.UserEntity;
import com.example.runningclubs.repositories.RoleRepository;
import com.example.runningclubs.repositories.UserRepository;
import com.example.runningclubs.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDTO registrationDTO) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}

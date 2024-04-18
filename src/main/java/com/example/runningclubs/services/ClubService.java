package com.example.runningclubs.services;

import com.example.runningclubs.DTO.ClubDTO;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();
}

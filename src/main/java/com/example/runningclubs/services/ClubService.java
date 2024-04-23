package com.example.runningclubs.services;

import com.example.runningclubs.DTO.ClubDTO;
import com.example.runningclubs.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();
    Club saveClub(ClubDTO clubDTO);
    ClubDTO findClubById(long clubId);
    void updateClub(ClubDTO club);

    void delete(Long clubId);
    List<ClubDTO> searchClubs(String query);
}

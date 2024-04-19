package com.example.runningclubs.services.impl;

import com.example.runningclubs.DTO.ClubDTO;
import com.example.runningclubs.models.Club;
import com.example.runningclubs.repositories.ClubRepository;
import com.example.runningclubs.services.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDTO> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDTO(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    private ClubDTO mapToClubDTO(Club club) {
        ClubDTO clubDTO = ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .url(club.getUrl())
                .content(club.getContent())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .build();
        return clubDTO;
    }
}

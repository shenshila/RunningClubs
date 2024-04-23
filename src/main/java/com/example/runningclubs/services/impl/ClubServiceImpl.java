package com.example.runningclubs.services.impl;

import com.example.runningclubs.DTO.ClubDTO;
import com.example.runningclubs.models.Club;
import com.example.runningclubs.repositories.ClubRepository;
import com.example.runningclubs.services.ClubService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.runningclubs.mapper.ClubMapper.mapToClub;
import static com.example.runningclubs.mapper.ClubMapper.mapToClubDTO;

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
    public ClubDTO findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDTO(club);
    }

    @Override
    public void updateClub(ClubDTO clubDTO) {
        Club club = mapToClub(clubDTO);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDTO> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDTO(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDTO clubDTO) {
        Club club = mapToClub(clubDTO);
        return clubRepository.save(club);
    }
}

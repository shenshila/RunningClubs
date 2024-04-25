package com.example.runningclubs.mapper;

import com.example.runningclubs.DTO.ClubDTO;
import com.example.runningclubs.models.Club;

import java.util.stream.Collectors;

import static com.example.runningclubs.mapper.EventMapper.mapToEventDTO;

public class ClubMapper {
    public static Club mapToClub(ClubDTO club) {
        Club clubDTO = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .url(club.getUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .build();
        return clubDTO;
    }

    public static ClubDTO mapToClubDTO(Club club) {
        ClubDTO clubDTO = ClubDTO.builder()
                .id(club.getId())
                .title(club.getTitle())
                .url(club.getUrl())
                .content(club.getContent())
                .createdBy(club.getCreatedBy())
                .createOn(club.getCreateOn())
                .updateOn(club.getUpdateOn())
                .events(club.getEvents().stream().map(event -> mapToEventDTO(event)).collect(Collectors.toList()))
                .build();
        return clubDTO;
    }
}

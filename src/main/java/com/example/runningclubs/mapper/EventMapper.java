package com.example.runningclubs.mapper;

import com.example.runningclubs.DTO.EventDTO;
import com.example.runningclubs.models.Event;

public class EventMapper {
    public static Event mapToEvent(EventDTO eventDTO) {
        return Event.builder()
                .id(eventDTO.getId())
                .name(eventDTO.getName())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .type(eventDTO.getType())
                .url(eventDTO.getUrl())
                .createdOn(eventDTO.getCreatedOn())
                .updatedOn(eventDTO.getUpdatedOn())
                .club(eventDTO.getClub())
                .build();
    }

    public static EventDTO mapToEventDTO(Event event) {
        return EventDTO.builder()
                .id(event.getId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .url(event.getUrl())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .club(event.getClub())
                .build();
    }

}

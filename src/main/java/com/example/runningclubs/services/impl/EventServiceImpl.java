package com.example.runningclubs.services.impl;

import com.example.runningclubs.DTO.EventDTO;
import com.example.runningclubs.models.Club;
import com.example.runningclubs.models.Event;
import com.example.runningclubs.repositories.ClubRepository;
import com.example.runningclubs.repositories.EventRepository;
import com.example.runningclubs.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.runningclubs.mapper.ClubMapper.mapToClub;
import static com.example.runningclubs.mapper.EventMapper.mapToEvent;
import static com.example.runningclubs.mapper.EventMapper.mapToEventDTO;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDTO eventDTO) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDTO);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDTO> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDTO(event)).collect(Collectors.toList());
    }

    @Override
    public EventDTO findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDTO(event);
    }

    @Override
    public void updateEvent(EventDTO eventDTO) {
        Event event = mapToEvent(eventDTO);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}

package com.example.runningclubs.repositories;

import com.example.runningclubs.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

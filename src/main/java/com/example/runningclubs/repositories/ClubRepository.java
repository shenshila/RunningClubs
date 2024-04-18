package com.example.runningclubs.repositories;

import com.example.runningclubs.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findById(String url);
}
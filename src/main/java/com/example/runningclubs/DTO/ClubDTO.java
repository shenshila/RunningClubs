package com.example.runningclubs.DTO;

import com.example.runningclubs.models.UserEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDTO {
    private Long id;
    @NotEmpty(message = "Club title should not be empty")
    private String title;
    @NotEmpty(message = "Photo link should not be empty")
    private String url;
    @NotEmpty(message = "Content should not be empty")
    private String content;
    private UserEntity createdBy;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;
    private List<EventDTO> events;
}

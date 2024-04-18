package com.example.runningclubs.DTO;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class ClubDTO {
    private Long id;
    private String title;
    private String url;
    private String content;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;
}

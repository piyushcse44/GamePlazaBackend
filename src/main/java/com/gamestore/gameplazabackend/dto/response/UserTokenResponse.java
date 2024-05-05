package com.gamestore.gameplazabackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenResponse {
    private String token;
    private LocalDate createdDate;
    private LocalTime createdTime;
}

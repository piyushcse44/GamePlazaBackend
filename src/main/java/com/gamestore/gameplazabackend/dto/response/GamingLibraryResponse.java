package com.gamestore.gameplazabackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GamingLibraryResponse {
    private Long gameId;
    private String gameName;
    private String companyName;
    private String featureImage;
    private LocalDate dateAdded;
    private Integer hoursPlayed;
}

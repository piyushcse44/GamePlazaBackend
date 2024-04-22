package com.gamestore.gameplazabackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameListResponse {
    private Long gameId;
    private String gameName;
    private String companyName;
    private BigDecimal gameRating;
    private String totalDownloads;
    private String featureImage;
}

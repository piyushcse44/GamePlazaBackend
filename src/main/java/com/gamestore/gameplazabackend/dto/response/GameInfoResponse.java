package com.gamestore.gameplazabackend.dto.response;

import com.gamestore.gameplazabackend.model.Cons;
import com.gamestore.gameplazabackend.model.Genre;
import com.gamestore.gameplazabackend.model.Pros;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameInfoResponse {
    private Long gameId;
    private String gameName;
    private String developerName;
    private String companyName;
    private BigDecimal gameSizeInMb;
    private String gameLanguage;
    private List<Genre> gameGenera;
    private BigDecimal gamePriceInInr;
    private String featureImage;
    private String gameAbout;
    private String gameDesc;
    private String gameDownloadLink;
    private List<Pros> prosList;
    private List<Cons> consList;
    private String gameDevice;
    private Long totalDownloads;
    private BigDecimal gameRating;
    private LocalDateTime createdOn;
    private Integer hoursPlayed;
}

package com.gamestore.gameplazabackend.dto.request;

import com.gamestore.gameplazabackend.model.Cons;
import com.gamestore.gameplazabackend.model.Genera;
import com.gamestore.gameplazabackend.model.Pros;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameInfoRequest {

    private String gameName;
    private String developerName;
    private String companyName;
    private BigDecimal gameSizeInMb;
    private String gameLanguage;
    private List<Genera> gameGenera;
    private BigDecimal gamePriceInInr;
    @ApiModelProperty(value = "Feature image of the game", required = true)
    private MultipartFile featureImage;
    private String gameAbout;
    private String gameDesc;
    private String gameDownloadLink;
    private List<Pros> prosList;
    private List<Cons> consList;
    private String gameDevice;
    private Long totalDownloads;
    private BigDecimal gameRating;
    private LocalDateTime createdOn;

}

package com.gamestore.gameplazabackend.model;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name ="game_info")
public class GameInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;
    @Column(name="game_name")
    private String gameName;
    @Column(name="developer_name")
    private String developerName;
    @Column(name ="company_name")
    private String companyName;
    @Column(name ="size_mb",precision = 8,scale = 3)
    private BigDecimal gameSizeInMb;
    @Column(name="game_language")
    private String gameLanguage;
    @Column(name = "game_genre")
    @ManyToMany
    private List<Genre> gameGenera;
    @Column(name="game_price_in_inr",precision = 8,scale = 2)
    private BigDecimal gamePriceInInr;
    @Column(name = "feature_image")
    private String featureImage;
    @Column(name="game_about")
    private String gameAbout;
    @Column(name="game_description",columnDefinition = "TEXT")
    private String gameDesc;
    @Column(name = "game_download_link")
    private String gameDownloadLink;
    @Column(name = "game_pros")
    @ManyToMany
    private List<Pros> prosList;
    @Column(name = "game_cons")
    @ManyToMany
    private List<Cons> consList;
    @Column(name = "game_device")
    private String gameDevice;
    @Column(name = "total_downloads")
    private Long totalDownloads;
    @Column(name = "game_rating",precision = 2,scale = 1)
    private BigDecimal gameRating;
    @Column(name = "created_date")
    private LocalDateTime createdOn;
    @Column(name="last_updated_date")
    private LocalDateTime lastUpdatedOn;
    @Column(name = "hours_played")
    private Integer hoursPlayed;
    @ElementCollection
    @CollectionTable(name = "game_additional_image",
                      joinColumns = @JoinColumn(name = "game_id"))
    private List<String> additionalImage;
}

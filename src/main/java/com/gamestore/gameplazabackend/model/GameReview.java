package com.gamestore.gameplazabackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name ="game_review")
public class GameReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_review_id")
    private Long gameReviewId;

    @ManyToOne
    private GameInfo gameInfo;
    @Column(name = "review_rating",precision = 2,scale = 1)
    private BigDecimal gameRating;
    @Column(name = "review_body",columnDefinition = "TEXT")
    private String reviewBody;
}

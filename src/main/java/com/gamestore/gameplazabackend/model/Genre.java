package com.gamestore.gameplazabackend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="game_genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    @Column(name = "genre_type")
    private String genreType;
    @Column(name = "genre_spec",columnDefinition = "TEXT")
    private String genreSpec;


}

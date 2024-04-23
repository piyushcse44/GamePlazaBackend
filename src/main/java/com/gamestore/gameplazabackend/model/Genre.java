package com.gamestore.gameplazabackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

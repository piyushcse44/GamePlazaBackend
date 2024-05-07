package com.gamestore.gameplazabackend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="game_pros")
public class Pros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pros_id")
    private Long prosId;
    @Column(name = "pros_title")
    private String prosTitle;
    @Column(columnDefinition = "TEXT",name = "pros_body")
    private String prosBody;

}

package com.gamestore.gameplazabackend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="game_cons")
public class Cons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cons_id")
    Long ConsId;
    @Column(name = "cons_title")
    private String consTitle;
    @Column(columnDefinition = "TEXT",name = "cons_body")
    private String consBody;
}

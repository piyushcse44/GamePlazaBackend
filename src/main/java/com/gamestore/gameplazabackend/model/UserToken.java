package com.gamestore.gameplazabackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "user_token")

public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String email;

    @Column(name = "token")
    private String token;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

}

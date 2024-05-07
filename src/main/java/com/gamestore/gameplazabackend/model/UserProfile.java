package com.gamestore.gameplazabackend.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.proxy.LazyLoader;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_profile_id")
    private Long userProfileId;

    @OneToOne
    @JoinColumn(name = "game_user_id")
    private GameUser gameUser;

    private Boolean liveStatus;

    @Column(name = "profile_pic")
    private String profilePic;

    @ManyToMany
    @JoinTable(
            name = "profile_game_list",
            joinColumns = @JoinColumn(name = "user_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    private List<GameInfo> gameInfoList;


}

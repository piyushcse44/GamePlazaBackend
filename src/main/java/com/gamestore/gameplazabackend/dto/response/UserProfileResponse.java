package com.gamestore.gameplazabackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfileResponse {
    private String name;
    private String email;
    private String profilePic;
    private Boolean liveStatus;
    private Long numberOfGamesDownloaded;
    private Long numberOfFriendsOnline;
    private Long numberOfLivestream;
    private Long numberOfClips;

}

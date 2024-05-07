package com.gamestore.gameplazabackend.util;

import com.gamestore.gameplazabackend.dto.response.UserProfileResponse;
import com.gamestore.gameplazabackend.model.UserProfile;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserProfileUtil {

    public UserProfileResponse convertUserProfileToResponse(UserProfile userProfile)
    {
        UserProfileResponse userProfileResponse = new UserProfileResponse();
        BeanUtils.copyProperties(userProfile,userProfileResponse);
        if(userProfile.getGameUser().getUsername() !=null)
            userProfileResponse.setName(userProfile.getGameUser().getUsername());
        userProfileResponse.setEmail(userProfile.getGameUser().getEmail());
        userProfileResponse.setNumberOfClips(0L);
        if(userProfile.getGameInfoList() !=null)
            userProfileResponse.setNumberOfGamesDownloaded((long) userProfile.getGameInfoList().size());
        else
            userProfileResponse.setNumberOfGamesDownloaded(0L);

        userProfileResponse.setNumberOfFriendsOnline(0L);
        return userProfileResponse;
    }
}

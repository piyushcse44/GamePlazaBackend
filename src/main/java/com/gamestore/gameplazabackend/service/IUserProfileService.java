package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.response.UserProfileResponse;
import com.gamestore.gameplazabackend.model.UserProfile;

public interface IUserProfileService {
   UserProfileResponse getProfileInfo(String email);
   UserProfileResponse setProfileInfo(UserProfile userProfile);

}

package com.gamestore.gameplazabackend.controller;


import com.gamestore.gameplazabackend.dto.response.UserProfileResponse;
import com.gamestore.gameplazabackend.service.IUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/")
public class UserProfileController {

    @Autowired
    private IUserProfileService userProfileService;

    @GetMapping(path = "/profile/{email}")
    public UserProfileResponse getProfileInfo(String email)
    {
        UserProfileResponse x = userProfileService.getProfileInfo(email);
        return userProfileService.getProfileInfo(email);
    }
}

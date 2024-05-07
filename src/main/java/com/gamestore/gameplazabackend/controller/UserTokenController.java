package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.dto.response.UserTokenResponse;
import com.gamestore.gameplazabackend.service.IUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/userToken")
public class UserTokenController {

    @Autowired
    private IUserTokenService userTokenService;

    @GetMapping(path = "")
    public List<UserTokenResponse> fetchUserLoginHistory(String email)
    {
        return userTokenService.fetchUserLoginHistory(email);
    }

}

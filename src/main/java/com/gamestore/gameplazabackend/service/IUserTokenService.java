package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.response.UserTokenResponse;
import com.gamestore.gameplazabackend.model.GameUser;

import java.util.List;

public interface IUserTokenService {
    public void saveUserToken(String email, String token);
    public List<UserTokenResponse> fetchUserLoginHistory(String email);
}

package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.model.GameUser;

public interface IUserTokenService {
    public void saveUserToken(GameUser user, String token);
}

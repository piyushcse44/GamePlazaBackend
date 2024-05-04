package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.model.GameUser;
import com.gamestore.gameplazabackend.model.UserToken;
import com.gamestore.gameplazabackend.repository.IUserTokenRepository;
import com.gamestore.gameplazabackend.service.IUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTokenServiceImpl implements IUserTokenService {
    @Autowired
    private IUserTokenRepository userTokenRepository;

    @Override
    public void saveUserToken(GameUser user, String token) {
        // Create a new UserToken instance and set the user and token
        UserToken userToken = new UserToken();
        userToken.setUser(user);
        userToken.setToken(token);

        // Save the UserToken instance to the database using the repository
        userTokenRepository.save(userToken);
    }
}

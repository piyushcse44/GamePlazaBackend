package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.dto.response.UserProfileResponse;
import com.gamestore.gameplazabackend.model.GameUser;
import com.gamestore.gameplazabackend.model.UserProfile;
import com.gamestore.gameplazabackend.repository.IUserProfileRepository;
import com.gamestore.gameplazabackend.service.IGameUserService;
import com.gamestore.gameplazabackend.service.IUserProfileService;
import com.gamestore.gameplazabackend.util.UserProfileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserProfileServiceImpl implements IUserProfileService {

    @Autowired
    private IUserProfileRepository userProfileRepository;
    @Autowired
    private UserProfileUtil userProfileUtil;

    @Autowired
    private IGameUserService gameUserService;

    @Override
    public UserProfileResponse getProfileInfo(String email) {
        GameUser gameUser = gameUserService.findByEmail(email);
        UserProfile userProfile = userProfileRepository.findByGameUser(gameUser).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Email:"+email+" does not registered."
                )
        );


        return userProfileUtil.convertUserProfileToResponse(userProfile);

    }

    @Override
    public UserProfileResponse setProfileInfo(UserProfile userProfile) {
        if(userProfile == null || userProfile.getGameUser()==null ||
                userProfile.getGameUser().getEmail()==null
        || !gameUserService.isValid( userProfile.getGameUser().getEmail()))
        {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Email is not Registered"
            );
        }
        userProfile=userProfileRepository.save(userProfile);
        return userProfileUtil.convertUserProfileToResponse(userProfile);

    }
}

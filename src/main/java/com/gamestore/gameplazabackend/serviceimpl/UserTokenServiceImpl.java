package com.gamestore.gameplazabackend.serviceimpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamestore.gameplazabackend.dto.response.UserTokenResponse;
import com.gamestore.gameplazabackend.model.GameInfo;
import com.gamestore.gameplazabackend.model.GameUser;
import com.gamestore.gameplazabackend.model.UserToken;
import com.gamestore.gameplazabackend.repository.IUserTokenRepository;
import com.gamestore.gameplazabackend.service.IGameUserService;
import com.gamestore.gameplazabackend.service.IUserTokenService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTokenServiceImpl implements IUserTokenService {
    @Autowired
    private IUserTokenRepository userTokenRepository;



    @Override
    public void saveUserToken(String email, String token) {

        UserToken userToken = new UserToken();
        userToken.setEmail(email);
        userToken.setToken(token);
        userToken.setCreatedOn(LocalDateTime.now());
        userTokenRepository.save(userToken);
    }

    @Override
    public List<UserTokenResponse> fetchUserLoginHistory(String email) {
        List<UserToken> userTokenList = userTokenRepository.findByEmail(email);
        if (userTokenList.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No User register with UserName:" + email
            );
        List<UserTokenResponse> userTokenResponseList;

        userTokenResponseList = userTokenList
                .stream()
                .map((userToken) -> {
                        UserTokenResponse userTokenResponse = new UserTokenResponse();
                        userTokenResponse.setToken(userToken.getToken());
                        LocalDate localDate =   userToken.getCreatedOn().toLocalDate();
                        userTokenResponse.setCreatedDate(
                              localDate.toString()
                        );
                        userTokenResponse.setCreatedTime(
                                userToken.getCreatedOn().toLocalTime().toString()
                        );
                        return userTokenResponse;
                   }
                ).collect(Collectors.toList());
        return userTokenResponseList;
    }
}
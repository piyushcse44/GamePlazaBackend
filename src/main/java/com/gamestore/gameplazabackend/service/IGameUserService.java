package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.AuthenticationRequest;
import com.gamestore.gameplazabackend.dto.request.RegisterRequest;
import com.gamestore.gameplazabackend.dto.response.AuthenticationResponse;
import com.gamestore.gameplazabackend.model.GameUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IGameUserService extends UserDetailsService {
    public String register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request);
    public Boolean isValid(String email);
    public GameUser findByEmail(String email);
}

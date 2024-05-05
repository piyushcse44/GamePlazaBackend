package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.dto.request.AuthenticationRequest;
import com.gamestore.gameplazabackend.dto.request.RegisterRequest;
import com.gamestore.gameplazabackend.dto.response.AuthenticationResponse;
import com.gamestore.gameplazabackend.jwt.JwtHelper;
import com.gamestore.gameplazabackend.service.IGameUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/auth")
public class GameUserController {
    @Autowired
    private IGameUserService gameUserService;

    @PostMapping("/register")
    public String register(
            @RequestBody RegisterRequest request
    ) {
        return gameUserService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(gameUserService.authenticate(request));
    }


}

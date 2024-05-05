package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.dto.request.AuthenticationRequest;
import com.gamestore.gameplazabackend.dto.request.RegisterRequest;
import com.gamestore.gameplazabackend.dto.response.AuthenticationResponse;
import com.gamestore.gameplazabackend.jwt.JwtHelper;
import com.gamestore.gameplazabackend.model.GameUser;
import com.gamestore.gameplazabackend.repository.IGameUserRepository;
import com.gamestore.gameplazabackend.service.IGameUserService;
import com.gamestore.gameplazabackend.service.IUserTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class GameUserServiceImpl implements IGameUserService {


    private final IGameUserRepository gameUserRepository;

    private final PasswordEncoder passwordEncoder;


    private final IUserTokenService userTokenService;


    private final AuthenticationManager authenticationManager;


    private final JwtHelper helper;


    @Lazy
    @Autowired
    public GameUserServiceImpl(IGameUserRepository gameUserRepository, PasswordEncoder passwordEncoder, IUserTokenService userTokenService, AuthenticationManager authenticationManager, JwtHelper helper) {
        this.gameUserRepository = gameUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.userTokenService = userTokenService;
        this.authenticationManager = authenticationManager;
        this.helper = helper;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<GameUser> optionalGameUser;
        try {
            optionalGameUser = gameUserRepository.findByUserEmail(email);
        }
        catch(Exception e)
        {
            throw new RuntimeException("Error occurs in findBy Email service msg:"+
                    e.getMessage());
        }
        if(optionalGameUser.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User With Email:"+email+" Does not exists"
            );
        return optionalGameUser.get();
    }

    @Override
    public String register(RegisterRequest request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        var user = GameUser.builder()
                .userName(request.getName())
                .userEmail(request.getEmail())
                .userPassword(encodedPassword)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isAccountNonExpired(true)
                .build();
        var savedUser = gameUserRepository.save(user);
        return "User registered successfully";
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = loadUserByUsername(request.getEmail());
            String token = this.helper.generateToken(userDetails);

            return AuthenticationResponse.builder()
                    .jwtToken(token)
                    .userName(userDetails.getUsername()).build();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Authentication failed " + ex.getMessage());
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }


}

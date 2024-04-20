package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.dto.request.GameInfoRequest;
import com.gamestore.gameplazabackend.dto.response.GameInfoResponse;
import com.gamestore.gameplazabackend.dto.response.GameListResponse;
import com.gamestore.gameplazabackend.service.IGameInfoService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/game_plaza")
public class GameInfoController {

    @Autowired
    private final IGameInfoService gameInfoService;

    public GameInfoController(IGameInfoService gameInfoService)
    {
        this.gameInfoService = gameInfoService;
    }


    @GetMapping(path ="/game_list")
    public List<GameListResponse> getAllGameList()
    {
        return gameInfoService.fetchAllGameList();
    }

    @PostMapping(path = "/game_info")
    public GameInfoResponse addGameInfo(@ModelAttribute GameInfoRequest gameInfoRequest)
    {
        return gameInfoService.addGameInfo(gameInfoRequest);
    }

}

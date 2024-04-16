package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.dto.request.GameInfoRequest;
import com.gamestore.gameplazabackend.dto.response.GameInfoResponse;
import com.gamestore.gameplazabackend.dto.response.GameListResponse;
import com.gamestore.gameplazabackend.service.IGameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class GameInfoController {

    @Autowired
    private final IGameInfoService gameInfoService;

    public GameInfoController(IGameInfoService gameInfoService)
    {
        this.gameInfoService = gameInfoService;
    }

    @GetMapping(path ="/get-all-game-list")
    public List<GameListResponse> getAllGameList()
    {
        return gameInfoService.fetchAllGameList();
    }


    @PostMapping(path = "/add-game-info")
    public GameInfoResponse addGameInfo(@ModelAttribute GameInfoRequest gameInfoRequest)
    {
        return gameInfoService.addGameInfo(gameInfoRequest);
    }

}

package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.dto.request.GameInfoRequest;
import com.gamestore.gameplazabackend.dto.response.GameInfoResponse;
import com.gamestore.gameplazabackend.dto.response.GameListResponse;
import com.gamestore.gameplazabackend.dto.response.GamingLibraryResponse;
import com.gamestore.gameplazabackend.dto.response.PagingResponse;
import com.gamestore.gameplazabackend.service.IGameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public PagingResponse<GameListResponse> getPageOfGameList(
            @RequestParam(value = "pageSize",defaultValue ="8",required = false) Integer pageSize,
            @RequestParam(value = "pageNumber",defaultValue ="1",required = false) Integer pageNumber,
            @RequestParam(value = "sortBy",defaultValue = "gameRating",required = false) String sortBy
    )
    {
        return gameInfoService.getPageOfGameList(pageSize,pageNumber-1,sortBy);
    }

    @GetMapping(path = "/search/game_list")
    public PagingResponse<GameListResponse> searchGameListByGameAndCompanyName(
            @RequestParam(value = "pageSize",defaultValue ="8",required = false) Integer pageSize,
            @RequestParam(value = "pageNumber",defaultValue ="1",required = false) Integer pageNumber,
            @RequestParam(value = "sortBy",defaultValue = "gameRating",required = false) String sortBy,
            @RequestParam(value ="searchedWord",defaultValue = "",required = false) String searchedWord
    )
    {
        return gameInfoService.searchGameListByGameAndCompanyName(searchedWord,pageSize,pageNumber,sortBy);
    }

    @GetMapping(path = "/gaming_library")
    public List<GamingLibraryResponse> getGamingLibraryByPageS()
    {
        return  gameInfoService.fetchAllGamingLibrary();
    }
    @PostMapping(path = "/game_info")
    public GameInfoResponse addGameInfo(@ModelAttribute GameInfoRequest gameInfoRequest)
    {
        return gameInfoService.addGameInfo(gameInfoRequest);
    }

}

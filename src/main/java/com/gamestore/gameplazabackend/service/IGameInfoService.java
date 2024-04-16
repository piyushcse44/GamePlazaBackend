package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.GameInfoRequest;
import com.gamestore.gameplazabackend.dto.response.GameInfoResponse;
import com.gamestore.gameplazabackend.dto.response.GameListResponse;
import com.gamestore.gameplazabackend.dto.response.GameSpecificationResponse;
import com.gamestore.gameplazabackend.dto.response.GamingLibraryResponse;

import java.util.List;

public interface IGameInfoService
{
    public List<GameListResponse> fetchAllGameList();
    public List<GameSpecificationResponse> fetchAllGameSpecification();
    public List<GamingLibraryResponse> fetchAllGamingLibrary();
    public GameListResponse fetchGameListById(Long id);
    public GameSpecificationResponse fetchGameSpecificationById(Long id);
    public GamingLibraryResponse fetchGamingLibraryById(Long id);
    public GameInfoResponse addGameInfo(GameInfoRequest gameInfoRequest);
    public GameInfoResponse updateGameInfo(Long id,GameInfoRequest gameInfoRequest);
    public String deleteGameInfoById(Long id);

}

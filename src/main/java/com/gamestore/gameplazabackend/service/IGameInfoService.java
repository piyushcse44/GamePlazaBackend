package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.GameInfoRequest;
import com.gamestore.gameplazabackend.dto.response.*;

import java.io.InputStream;
import java.util.List;

public interface IGameInfoService
{
    public PagingResponse<GameListResponse> getPageOfGameList(Integer pageSize, Integer pageNumber);
    public List<GameSpecificationResponse> fetchAllGameSpecification();
    public List<GamingLibraryResponse> fetchAllGamingLibrary();
    public GameListResponse fetchGameListById(Long id);
    public GameSpecificationResponse fetchGameSpecificationById(Long id);
    public GamingLibraryResponse fetchGamingLibraryById(Long id);
    public InputStream fetchImageByUrl(String url);
    public GameInfoResponse addGameInfo(GameInfoRequest gameInfoRequest);
    public GameInfoResponse updateGameInfo(Long id,GameInfoRequest gameInfoRequest);
    public String deleteGameInfoById(Long id);

}

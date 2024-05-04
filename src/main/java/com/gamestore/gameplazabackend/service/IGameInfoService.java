package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.GameInfoRequest;
import com.gamestore.gameplazabackend.dto.response.*;

import java.io.InputStream;
import java.util.List;

public interface IGameInfoService
{
    PagingResponse<GameListResponse> getPageOfGameList(Integer pageSize, Integer pageNumber, String sortBy);
    PagingResponse<GameListResponse> searchGameListByGameAndCompanyName(String searchedWord, Integer pageSize, Integer pageNumber, String sortBy);
    List<GameSpecificationResponse> fetchAllGameSpecification();
    List<GamingLibraryResponse> fetchAllGamingLibrary();
    GameListResponse fetchGameListById(Long id);
    GameSpecificationResponse fetchGameSpecificationById(Long id);
    GamingLibraryResponse fetchGamingLibraryById(Long id);
    InputStream fetchImageByUrl(String url);
    GameInfoResponse addGameInfo(GameInfoRequest gameInfoRequest);
    GameInfoResponse updateGameInfo(Long id,GameInfoRequest gameInfoRequest);
    String deleteGameInfoById(Long id);

}

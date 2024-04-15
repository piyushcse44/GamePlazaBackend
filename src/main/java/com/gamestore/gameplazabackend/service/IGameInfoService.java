package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.response.GameListResponse;

import java.util.List;

public interface IGameInfoService
{
    public List<GameListResponse> fetchAllGameList();
    public GameListResponse fetchGameById(Long id);


}

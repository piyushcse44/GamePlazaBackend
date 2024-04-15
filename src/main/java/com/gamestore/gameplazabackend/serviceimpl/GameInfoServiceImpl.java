package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.repository.IGameInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameInfoServiceImpl {
    @Autowired
    private final IGameInfoRepository gameInfoRepository;
    public GameInfoServiceImpl(IGameInfoRepository gameInfoRepository)
    {
        this.gameInfoRepository = gameInfoRepository;
    }



}

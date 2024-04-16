package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.dto.request.GameInfoRequest;
import com.gamestore.gameplazabackend.dto.response.GameInfoResponse;
import com.gamestore.gameplazabackend.dto.response.GameListResponse;
import com.gamestore.gameplazabackend.dto.response.GameSpecificationResponse;
import com.gamestore.gameplazabackend.dto.response.GamingLibraryResponse;
import com.gamestore.gameplazabackend.model.Cons;
import com.gamestore.gameplazabackend.model.GameInfo;
import com.gamestore.gameplazabackend.model.Genera;
import com.gamestore.gameplazabackend.model.Pros;
import com.gamestore.gameplazabackend.repository.IGameInfoRepository;
import com.gamestore.gameplazabackend.repository.IConsRepository;
import com.gamestore.gameplazabackend.service.IGameInfoService;
import com.gamestore.gameplazabackend.repository.IGeneraRepository;
import com.gamestore.gameplazabackend.repository.IProsRepository;
import com.gamestore.gameplazabackend.util.GameInfoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Service
public class GameInfoServiceImpl implements IGameInfoService {


    @Autowired
    private final IGameInfoRepository gameInfoRepository;
    @Autowired
    private final IProsRepository prosRepository;
    @Autowired
    private final IConsRepository consRepository;
    @Autowired
    private final IGeneraRepository generaRepository;

    @Autowired
    private final GameInfoUtil gameInfoUtil;


    public GameInfoServiceImpl(
            IGameInfoRepository gameInfoRepository,
            IProsRepository prosRepository, IConsRepository consRepository,
            IGeneraRepository generaRepository,GameInfoUtil gameInfoUtil
    ) {
        this.gameInfoRepository = gameInfoRepository;
        this.prosRepository = prosRepository;
        this.consRepository = consRepository;
        this.generaRepository = generaRepository;
        this.gameInfoUtil = gameInfoUtil;
    }

    @Override
    public List<GameListResponse> fetchAllGameList() {
        try {
            List<GameInfo> gameInfoList = gameInfoRepository
                    .findAll();
            return gameInfoUtil.changeToGameListResponse(gameInfoList);
        }
        catch(Exception e)
            {
                throw new RuntimeException("error occurs in fetch all game list " +
                        "error :"+e.getMessage());
            }

    }

    @Override
    public List<GameSpecificationResponse> fetchAllGameSpecification() {
        return null;
    }

    @Override
    public List<GamingLibraryResponse> fetchAllGamingLibrary() {
        return null;
    }

    @Override
    public GameListResponse fetchGameListById(Long id) {
        GameInfo gameInfo = gameInfoRepository.findById(id)
                .orElseThrow(
                        ()-> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "gameInfo with id: "+id
                                +"does not exists"
                        )
                );
        try {
            GameListResponse gameListResponse = new GameListResponse();
            BeanUtils.copyProperties(gameInfo, gameListResponse);
            return gameListResponse;
        } catch (Exception e)
        {
            throw new RuntimeException("Error Occurs in fetchGameById"+
                    "error: "+e.getMessage());
        }
    }

    @Override
    public GameSpecificationResponse fetchGameSpecificationById(Long id) {
        return null;
    }

    @Override
    public GamingLibraryResponse fetchGamingLibraryById(Long id) {
        return null;
    }

    @Override
    public GameInfoResponse addGameInfo(GameInfoRequest gameInfoRequest) {
        try {
            GameInfo gameInfo = new GameInfo();
            List<Genera> generaList = gameInfoRequest.getGameGenera();
            if (generaList != null)
                generaList.replaceAll(generaRepository::save);
            List<Pros> prosList = gameInfoRequest.getProsList();
            if (prosList != null)
                prosList.replaceAll(prosRepository::save);
            List<Cons> consList = gameInfoRequest.getConsList();
            if (consList != null)
                consList.replaceAll(consRepository::save);
            BeanUtils.copyProperties(gameInfoRequest, gameInfo);
            gameInfo.setLastUpdatedOn(LocalDateTime.now());
            gameInfo.setHoursPlayed(0);
            MultipartFile featureImage = gameInfoRequest.getFeatureImage();
            String featureImagePath = gameInfoUtil.saveImageToDir(featureImage);
            gameInfo.setFeatureImage(featureImagePath);
            gameInfo = gameInfoRepository.save(gameInfo);
            GameInfoResponse gameInfoResponse = new GameInfoResponse();
            BeanUtils.copyProperties(gameInfo, gameInfoResponse);
            return gameInfoResponse;
        } catch (Exception e) {
            throw new RuntimeException("Error occurs in addGameInfo serviceImpl error: "
                    + e.getMessage());
        }

    }

    @Override
    public GameInfoResponse updateGameInfo(Long id, GameInfoRequest gameInfoRequest) {
        return null;
    }

    @Override
    public String deleteGameInfoById(Long id) {
        return null;
    }
}

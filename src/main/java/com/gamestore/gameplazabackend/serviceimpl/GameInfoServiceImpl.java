package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.dto.request.GameInfoRequest;
import com.gamestore.gameplazabackend.dto.response.*;
import com.gamestore.gameplazabackend.model.Cons;
import com.gamestore.gameplazabackend.model.GameInfo;
import com.gamestore.gameplazabackend.model.Genre;
import com.gamestore.gameplazabackend.model.Pros;
import com.gamestore.gameplazabackend.repository.IGameInfoRepository;
import com.gamestore.gameplazabackend.service.IConsService;
import com.gamestore.gameplazabackend.service.IGameInfoService;
import com.gamestore.gameplazabackend.service.IGenreService;
import com.gamestore.gameplazabackend.service.IProsService;
import com.gamestore.gameplazabackend.util.GameInfoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@Service
public class GameInfoServiceImpl implements IGameInfoService {


    @Autowired
    private final IGameInfoRepository gameInfoRepository;
    @Autowired
    private final IProsService prosService;
    @Autowired
    private final IConsService consService;
    @Autowired
    private final IGenreService genreService;

    @Autowired
    private final GameInfoUtil gameInfoUtil;


    public GameInfoServiceImpl(
            IGameInfoRepository gameInfoRepository,
            IProsService prosService, IConsService consService,
            IGenreService genreService, GameInfoUtil gameInfoUtil
    ) {
        this.gameInfoRepository = gameInfoRepository;
        this.prosService = prosService;
        this.consService = consService;
        this.genreService = genreService;
        this.gameInfoUtil = gameInfoUtil;
    }

    @Override
    public PagingResponse<GameListResponse> getPageOfGameList(Integer pageSize, Integer pageNumber,String sortBy) {
        try {
            if (pageSize <= 0 || pageNumber < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid pageSize or pageNumber");
            }

            //paging
            Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
            Page<GameInfo> page = gameInfoRepository.findAll(p);

            List<GameListResponse>  gameListResponseList = gameInfoUtil.changeToGameListResponse(page.getContent());
            return  new PagingResponse<>(
                    gameListResponseList,
                    page.getNumber()+1,
                    page.getSize(),
                    page.getTotalElements(),
                    page.getTotalPages(),
                    page.isLast()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching game list: " + e.getMessage(), e);
        }
    }

    @Override
    public PagingResponse<GameListResponse> searchGameListByGameAndCompanyName(String searchedWord, Integer pageSize, Integer pageNumber, String sortBy) {
        try {
            if (pageSize <= 0 || pageNumber < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid pageSize or pageNumber");
            }

            //paging
            Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
            Page<GameInfo> page = gameInfoRepository.searchByNameAndCompanyName(searchedWord,p);

            List<GameListResponse>  gameListResponseList = gameInfoUtil.changeToGameListResponse(page.getContent());
            return  new PagingResponse<>(
                    gameListResponseList,
                    page.getNumber()+1,
                    page.getSize(),
                    page.getTotalElements(),
                    page.getTotalPages(),
                    page.isLast()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while searching game list by gameName and Company Name msg: " + e.getMessage(), e);
        }
    }


    @Override
    public List<GameSpecificationResponse> fetchAllGameSpecification() {
        return null;
    }

    @Override
    public List<GamingLibraryResponse> fetchAllGamingLibrary() {
        try {
            List<GameInfo> gameInfoList = gameInfoRepository
                    .findAll();
            return gameInfoUtil.changeToGameLibraryResponse(gameInfoList);
        }
        catch(Exception e)
        {
            throw new RuntimeException("error occurs in fetch all game library " +
                    "error :"+e.getMessage());
        }
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
        GameInfo gameInfo = gameInfoRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "gameInfo with id:"+id+" does not exists"
                )
        );
        return gameInfoUtil.convertToGameSpec(gameInfo);

    }

    @Override
    public GamingLibraryResponse fetchGamingLibraryById(Long id) {
        return null;
    }

    @Override
    public InputStream fetchImageByUrl(String url) {
        String path = gameInfoUtil.convertUrlToPath(url);
        try {
            InputStream inputStream = new FileInputStream(path);
            System.out.println("999" + inputStream.available());
            return inputStream;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("error in fetch image by url file not found msg:" + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("error in fetch image by url io exception msg:" + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("error in fetch image by url exception msg:" + e.getMessage());
        }
    }


    @Override
    public GameInfoResponse addGameInfo(GameInfoRequest gameInfoRequest) {
        try {
            GameInfo gameInfo = new GameInfo();
            BeanUtils.copyProperties(gameInfoRequest, gameInfo);
            gameInfo.setLastUpdatedOn(LocalDateTime.now());

            List<Genre> genreList = new ArrayList<>();
            if(gameInfoRequest.getGameGenreIdList()!=null)
            {
                for(Long genreId : gameInfoRequest.getGameGenreIdList())
                {
                    Genre genre = genreService.getGenreById(genreId);
                    genreList.add(genre);
                }
            }
            gameInfo.setGameGenera(genreList);


            List<Pros> prosList = new ArrayList<>();
            if(gameInfoRequest.getProsIdList()!=null)
            {
                for(Long prosId : gameInfoRequest.getProsIdList())
                {
                    Pros pros = prosService.getProsById(prosId);
                    prosList.add(pros);
                }
            }
            gameInfo.setProsList(prosList);


            List<Cons> consList = new ArrayList<>();
            if(gameInfoRequest.getConsIdList()!=null)
            {
                for(Long consId : gameInfoRequest.getConsIdList())
                {
                    Cons cons = consService.getConsById(consId);
                    consList.add(cons);
                }
            }
            gameInfo.setConsList(consList);


            gameInfo.setHoursPlayed(0);
            gameInfo.setCreatedOn(LocalDateTime.now());

            MultipartFile featureImage = gameInfoRequest.getFeatureImage();
            String featureImagePath = gameInfoUtil.saveImageToDir(featureImage);
            gameInfo.setFeatureImage(featureImagePath);

            List<String> additionalImagesPath = new ArrayList<>();
            List<MultipartFile> additionalImages = gameInfoRequest.getAdditionalImages();
            for(MultipartFile singleImage : additionalImages)
            {
                additionalImagesPath.add(gameInfoUtil.saveImageToDir(singleImage));
            }
            gameInfo.setAdditionalImage(additionalImagesPath);


            gameInfo = gameInfoRepository.save(gameInfo);
            GameInfoResponse gameInfoResponse = new GameInfoResponse();
            BeanUtils.copyProperties(gameInfo, gameInfoResponse);
            return gameInfoResponse;
        }
        catch (NullPointerException e)
        {
            return null;
        }
        catch (Exception e) {
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

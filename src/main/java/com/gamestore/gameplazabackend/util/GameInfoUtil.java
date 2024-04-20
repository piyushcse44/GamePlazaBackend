package com.gamestore.gameplazabackend.util;

import com.gamestore.gameplazabackend.dto.response.GameListResponse;
import com.gamestore.gameplazabackend.model.GameInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class GameInfoUtil {

    @Value("${image.domain}")
    private String imageDomain;
    @Value("${upload.dir}")
    private String uploadDir;

    @Value("${image.endpoint}")
    private String imageEndpoint;

    public  String saveImageToDir(MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                byte[] bytes = file.getBytes();
                String uniqueValue = LocalDateTime.now().toString();
                uniqueValue =uniqueValue.replace(':','-');
                uniqueValue =uniqueValue.replace('.','-');
                String fileName = uniqueValue+ Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s", "");;

                Path path = Paths.get(uploadDir + fileName);

                Files.write(path, bytes);

                return imageDomain +imageEndpoint+fileName;
            } catch (IOException e) {
                System.out.println("Failed to upload file: " + e.getMessage());
                return null;
            }
        } else {
            System.out.println("file is empty");
            return null;

        }
    }

    public String convertUrlToPath(String url)
    {
        return uploadDir+url;
    }





    public List<GameListResponse> changeToGameListResponse(List<GameInfo> gameInfoList)
    {
        List<GameListResponse> gameListResponseList = new ArrayList<>();
        for(GameInfo gameInfo : gameInfoList)
        {
            GameListResponse gameListResponse = new GameListResponse();
            BeanUtils.copyProperties(gameInfo,gameListResponse);
            gameListResponseList.add(gameListResponse);
        }
        return gameListResponseList;
    }

}

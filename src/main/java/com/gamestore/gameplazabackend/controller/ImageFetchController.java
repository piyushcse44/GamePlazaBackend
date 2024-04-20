package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.service.IGameInfoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@CrossOrigin
@RestController
@RequestMapping(path = "/${image.endpoint}")
public class ImageFetchController {

    @Autowired
    private  IGameInfoService gameInfoService;

    @GetMapping(path = "{url}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void fetchImage(
            @PathVariable String url,
            HttpServletResponse response
    )
    {
        try (InputStream resource = gameInfoService.fetchImageByUrl(url)) {
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(resource,response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException("error in fetchImage controller msg:"+e.getMessage());
        } catch (Exception e)
        {
            throw new RuntimeException("error in fetchImage controller msg in global exception: +" +
                    e.getMessage());
        }


    }

}

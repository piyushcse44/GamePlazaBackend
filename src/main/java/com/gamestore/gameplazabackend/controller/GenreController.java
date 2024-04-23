package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.dto.request.GenreRequest;
import com.gamestore.gameplazabackend.model.Genre;
import com.gamestore.gameplazabackend.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/game_plaza/genre")
public class GenreController {

    @Autowired
    private IGenreService genreService;
    @GetMapping(path = "")
    public List<Genre> getAllGenreInfo()
    {
        return genreService.getAllGenre();
    }
    @PostMapping(path = "")
    public Genre addGenreInfo(@RequestBody GenreRequest genreRequest)
    {
        return genreService.addGenre(genreRequest);
    }
}

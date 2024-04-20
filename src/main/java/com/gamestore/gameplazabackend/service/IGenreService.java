package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.GenreRequest;
import com.gamestore.gameplazabackend.model.Genre;

import java.util.List;

public interface IGenreService {
    public List<Genre> getAllGenre();
    public  Genre getGenreById(Long id);
    public Genre addGenre(GenreRequest genreRequest);
    public String deleteGenreById(Long id);
}

package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.GenreRequest;
import com.gamestore.gameplazabackend.model.Genre;

import java.util.List;

public interface IGenreService {
    List<Genre> getAllGenre();
    Genre getGenreById(Long id);
    Genre addGenre(GenreRequest genreRequest);
    String deleteGenreById(Long id);
}

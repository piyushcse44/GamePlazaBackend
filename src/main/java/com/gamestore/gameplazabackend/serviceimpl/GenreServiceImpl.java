package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.dto.request.GenreRequest;
import com.gamestore.gameplazabackend.model.Genre;
import com.gamestore.gameplazabackend.repository.IGenreRepository;
import com.gamestore.gameplazabackend.service.IGenreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements IGenreService {

    @Autowired
    private IGenreRepository genreRepository;
    @Override
    public List<Genre> getAllGenre() {
        try{
            return genreRepository.findAll();
        }
        catch (Exception e)
        {
            throw new RuntimeException("error in getAllGenre service msg: "+e.getMessage());
        }
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Genre with id:"
                        +id+" does not exists"
                )
        );
    }

    @Override
    public Genre addGenre(GenreRequest genreRequest) {
        if(genreRequest == null || genreRequest.getGeneraType()==null
                || genreRequest.getGeneraType().trim().isEmpty()
        )
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Request Body or title must not be null"
            );
        }
        try{
            Genre genre = new Genre();

            BeanUtils.copyProperties(genreRequest,genre);
            genreRepository.save(genre);
            return genre;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Exception occurs in addGenre service with msg:"+
                    e.getMessage());
        }

    }

    @Override
    public String deleteGenreById(Long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Genre with id:"
                            +id+" does not exists");
        return "deleted Successfully";

    }
}

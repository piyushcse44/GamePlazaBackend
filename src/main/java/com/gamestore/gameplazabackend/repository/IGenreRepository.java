package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre,Long> {
}

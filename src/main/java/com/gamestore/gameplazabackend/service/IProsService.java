package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.ProsRequest;
import com.gamestore.gameplazabackend.model.Pros;

import java.util.List;

public interface IProsService {
    List<Pros> getAllPros();
    Pros getProsById(Long id);
    Pros addPros(ProsRequest prosRequest);
    String deleteProsById(Long id);
}

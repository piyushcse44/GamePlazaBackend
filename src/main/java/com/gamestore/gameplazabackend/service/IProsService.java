package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.ProsRequest;
import com.gamestore.gameplazabackend.model.Pros;

import java.util.List;

public interface IProsService {
    public List<Pros> getAllPros();
    public  Pros getProsById(Long id);
    public Pros addPros(ProsRequest prosRequest);
    public String deleteProsById(Long id);
}

package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.ConsRequest;
import com.gamestore.gameplazabackend.model.Cons;

import java.util.List;

public interface IConsService {
    List<Cons> getAllCons();
    Cons getConsById(Long id);
    Cons addCons(ConsRequest consRequest);
    String deleteConsById(Long id);
}

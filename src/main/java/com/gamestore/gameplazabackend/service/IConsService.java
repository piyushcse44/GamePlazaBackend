package com.gamestore.gameplazabackend.service;

import com.gamestore.gameplazabackend.dto.request.ConsRequest;
import com.gamestore.gameplazabackend.model.Cons;

import java.util.List;

public interface IConsService {
    public List<Cons> getAllCons();
    public  Cons getConsById(Long id);
    public Cons addCons(ConsRequest consRequest);
    public String deleteConsById(Long id);
}

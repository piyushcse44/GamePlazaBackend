package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.dto.request.ConsRequest;
import com.gamestore.gameplazabackend.model.Cons;
import com.gamestore.gameplazabackend.service.IConsService;
import com.gamestore.gameplazabackend.serviceimpl.ConsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/game_plaza/cons")
public class ConsController {

    @Autowired
    private IConsService consService;
    @GetMapping(path = "/")
    public List<Cons> getAllConsInfo()
    {
        return consService.getAllCons();
    }
    @PostMapping(path = "/")
    public Cons addConsInfo(@RequestBody ConsRequest consRequest)
    {
        return consService.addCons(consRequest);
    }
}

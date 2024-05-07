package com.gamestore.gameplazabackend.controller;

import com.gamestore.gameplazabackend.dto.request.ProsRequest;
import com.gamestore.gameplazabackend.model.Pros;
import com.gamestore.gameplazabackend.service.IProsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/game_plaza/pros")
public class ProsController {

    @Autowired
    private IProsService prosService;
    @GetMapping(path = "")
    public List<Pros> getAllProsInfo()
    {
        return prosService.getAllPros();
    }
    @PostMapping(path = "")
    public Pros addProsInfo(@RequestBody ProsRequest prosRequest)
    {
        return prosService.addPros(prosRequest);
    }
}

package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.dto.request.ProsRequest;
import com.gamestore.gameplazabackend.model.Pros;
import com.gamestore.gameplazabackend.repository.IProsRepository;
import com.gamestore.gameplazabackend.service.IProsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProsServiceImpl implements IProsService {

    @Autowired
    private IProsRepository prosRepository;
    @Override
    public List<Pros> getAllPros() {
        try{
            return prosRepository.findAll();
        }
        catch (Exception e)
        {
            throw new RuntimeException("error in getAllPros service msg: "+e.getMessage());
        }
    }

    @Override
    public Pros getProsById(Long id) {
        return prosRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Pros with id:"
                +id+" does not exists"
                )
        );
    }

    @Override
    public Pros addPros(ProsRequest prosRequest) {
        if(prosRequest == null || prosRequest.getProsTitle()==null
        || prosRequest.getProsTitle().trim().isEmpty()
        )
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Request Body or title must not be null"
            );
        }
        try{
            Pros pros = new Pros();
            BeanUtils.copyProperties(prosRequest,pros);
            prosRepository.save(pros);
            return pros;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Exception occurs in addPros service with msg:"+
            e.getMessage());
        }

    }

    @Override
    public String deleteProsById(Long id) {
        Optional<Pros> pros = prosRepository.findById(id);
        if(pros.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Pros with id:"
                            +id+" does not exists");
        return "deleted Successfully";

    }
}

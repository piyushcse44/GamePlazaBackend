package com.gamestore.gameplazabackend.serviceimpl;

import com.gamestore.gameplazabackend.dto.request.ConsRequest;
import com.gamestore.gameplazabackend.model.Cons;
import com.gamestore.gameplazabackend.repository.IConsRepository;
import com.gamestore.gameplazabackend.service.IConsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ConsServiceImpl implements IConsService {

    @Autowired
    private IConsRepository consRepository;
    @Override
    public List<Cons> getAllCons() {
        try{
            return consRepository.findAll();
        }
        catch (Exception e)
        {
            throw new RuntimeException("error in getAllCons service msg: "+e.getMessage());
        }
    }

    @Override
    public Cons getConsById(Long id) {
        return consRepository.findById(id).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cons with id:"
                        +id+" does not exists"
                )
        );
    }

    @Override
    public Cons addCons(ConsRequest consRequest) {
        if(consRequest == null || consRequest.getConsTitle()==null
                || consRequest.getConsTitle().trim().isEmpty()
        )
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Request Body or title must not be null"
            );
        }
        try{
            Cons cons = new Cons();
            BeanUtils.copyProperties(consRequest,cons);
            consRepository.save(cons);
            return cons;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Exception occurs in addCons service with msg:"+
                    e.getMessage());
        }

    }

    @Override
    public String deleteConsById(Long id) {
        Optional<Cons> cons = consRepository.findById(id);
        if(cons.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Cons with id:"
                            +id+" does not exists");
        return "deleted Successfully";

    }
}

package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.Cons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsRepository extends JpaRepository<Cons,Long> {
}

package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.Pros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProsRepository extends JpaRepository<Pros,Long> {
}

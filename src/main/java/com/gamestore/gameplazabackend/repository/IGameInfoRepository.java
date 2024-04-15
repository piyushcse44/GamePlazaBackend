package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.GameInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameInfoRepository extends JpaRepository<GameInfo,Long> {
}

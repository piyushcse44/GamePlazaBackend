package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.GameInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameInfoRepository extends JpaRepository<GameInfo, Long> {

    @Query("SELECT g FROM GameInfo g " +
            "WHERE ( g.gameName LIKE %:searchedWord%) " +
            "OR ( g.companyName LIKE %:searchedWord%) " )
    Page<GameInfo> searchByNameAndCompanyName(String searchedWord, Pageable pageable);


}

package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.GameUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGameUserRepository  extends JpaRepository<GameUser,Long> {
    @Query("SELECT u FROM GameUser u WHERE u.userEmail = :userEmail")
    Optional<GameUser> findByUserEmail(String userEmail);

}

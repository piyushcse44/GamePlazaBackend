package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.GameUser;
import com.gamestore.gameplazabackend.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserProfileRepository  extends JpaRepository<UserProfile,Long> {
    @Query("SELECT u FROM UserProfile u WHERE u.gameUser = :gameUser")
    Optional<UserProfile> findByGameUser(GameUser gameUser);

}

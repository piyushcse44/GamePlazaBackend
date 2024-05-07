package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.GameUser;
import com.gamestore.gameplazabackend.model.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserTokenRepository extends JpaRepository<UserToken,Long> {
    @Query("SELECT u FROM UserToken u WHERE u.email = :email")
    List<UserToken> findByEmail(String email);
}

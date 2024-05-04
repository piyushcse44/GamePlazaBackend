package com.gamestore.gameplazabackend.repository;

import com.gamestore.gameplazabackend.model.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTokenRepository extends JpaRepository<UserToken,Long> {
}

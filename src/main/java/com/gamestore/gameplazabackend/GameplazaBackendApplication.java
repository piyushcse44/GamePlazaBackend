package com.gamestore.gameplazabackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;


@SpringBootApplication
public class GameplazaBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(GameplazaBackendApplication.class, args);
	}



}

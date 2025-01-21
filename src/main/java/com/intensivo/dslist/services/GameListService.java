package com.intensivo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivo.dslist.dto.GameListDTO;
import com.intensivo.dslist.entities.GameList;
import com.intensivo.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> games = gameListRepository.findAll();
		return games.stream().map(x -> new GameListDTO(x)).toList();
	}

}
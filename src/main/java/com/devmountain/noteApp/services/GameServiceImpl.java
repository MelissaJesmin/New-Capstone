package com.devmountain.noteApp.services;

import com.devmountain.noteApp.entities.Game;
import com.devmountain.noteApp.repositories.GameRepository;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    // Link the repository
    private final GameRepository gameRepository;

    // Service connects to the repository
    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll(); //  Find all is Jpa method
    }
}
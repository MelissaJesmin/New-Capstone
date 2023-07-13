package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.GameDto;
import com.devmountain.noteApp.entities.Game;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.GameRepository;
import com.devmountain.noteApp.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private UserRepository userRepository;


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

    @Override
    public List<GameDto> getAllGamesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<Game> gameList = gameRepository.findAllByUserEquals(userOptional.get());
            return gameList.stream().map(GameDto::new).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void addGame(GameDto gameDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Game game = new Game(gameDto);
        userOptional.ifPresent(game::setUser);
        gameRepository.saveAndFlush(game);
    }
}
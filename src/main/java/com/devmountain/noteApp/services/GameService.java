package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.GameDto;
import com.devmountain.noteApp.entities.Game;
import jakarta.transaction.Transactional;

import java.util.List;

public interface GameService {
    List<Game> getAllGames();

    List<GameDto> getAllGamesByUserId(Long userId);

    @Transactional
        void addGame(GameDto gameDto, Long userId);

    @Transactional
    void deleteGameById(Long userId);
}

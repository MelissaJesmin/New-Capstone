package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.GameDto;
import com.devmountain.noteApp.entities.Game;
import jakarta.transaction.Transactional;

import java.util.List;

public interface GameService {
    List<Game> getAllGames();


    @Transactional
        void addGame(GameDto gameDto, Long userId);
}

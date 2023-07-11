package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.dtos.GameDto;
import com.devmountain.noteApp.entities.Game;
import com.devmountain.noteApp.repositories.GameRepository;
import com.devmountain.noteApp.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class GameController {
    // Link Service
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/game")
    public List<GameDto> getAllGames() {
        List<GameDto> gameDtos = gameService.getAllGames()
                .stream()
                .map(GameDto::new)
                .collect(Collectors.toList());
        return gameDtos;
    }
}



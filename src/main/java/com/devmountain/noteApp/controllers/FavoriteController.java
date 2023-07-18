package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.entities.Game;
import com.devmountain.noteApp.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/addFavoriteGame/{userId}")
    public void addFavorite(@PathVariable Long userId, @RequestBody Map<String, Object> requestBody) {
        Long gameId = Long.parseLong(requestBody.get("gameId").toString());
        favoriteService.addFavorite(userId, gameId);
    }

    @GetMapping("/favorites/{userId}")
    public Set<Game> getFavoriteGames(@PathVariable Long userId) {
        return favoriteService.getFavoriteGames(userId);
    }

    @DeleteMapping("/deleteFavorites/{userId}")
    public void deleteFavoriteGameById(@PathVariable Long userId) {
        favoriteService.deleteFavoriteGameById(userId);
    }
}

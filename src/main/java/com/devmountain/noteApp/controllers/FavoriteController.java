package com.devmountain.noteApp.controllers;


import com.devmountain.noteApp.dtos.FavoriteDto;
import com.devmountain.noteApp.dtos.GameDto;
import com.devmountain.noteApp.entities.Favorite;
import com.devmountain.noteApp.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1:8080")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @PostMapping("/addFavoriteGame/{userId}")
    public void addFavoriteGame(@RequestBody FavoriteDto favoriteDto, @PathVariable Long userId) {
        favoriteService.addFavoriteGame(favoriteDto, userId);
    }


}

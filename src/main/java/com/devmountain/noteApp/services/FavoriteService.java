package com.devmountain.noteApp.services;

import com.devmountain.noteApp.entities.Favorite;
import com.devmountain.noteApp.entities.Game;
import jakarta.transaction.Transactional;

import java.util.Set;

public interface FavoriteService {
    void addFavorite(Long userId, Long gameId);

    Set<Game> getFavoriteGames(Long userId);

    @Transactional
    void deleteFavoriteGameById(Long userId);
}
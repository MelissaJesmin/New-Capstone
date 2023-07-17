package com.devmountain.noteApp.services;

import com.devmountain.noteApp.entities.Favorite;
import com.devmountain.noteApp.entities.Game;
import com.devmountain.noteApp.entities.User;
import com.devmountain.noteApp.repositories.FavoriteRepository;
import com.devmountain.noteApp.repositories.GameRepository;
import com.devmountain.noteApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, UserRepository userRepository, GameRepository gameRepository) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public void addFavorite(Long userId, Long gameId) {
        // Check if the User and Game exist in the database.
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found with ID: " + gameId));

        // Create a new Favorite object.
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setGame(game);

        // Save the favorite to the database.
        favoriteRepository.save(favorite);
    }

    @Override
    public Set<Game> getFavoriteGames(Long userId) {
        // Fetch the favorite games from the database for the given userId
        List<Favorite> favorites = favoriteRepository.findByUserId(userId);

        // Extract the games from the favorites list and return them in a set
        return favorites.stream()
                .map(Favorite::getGame)
                .collect(Collectors.toSet());
    }
}
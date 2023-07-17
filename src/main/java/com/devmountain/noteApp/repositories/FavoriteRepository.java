package com.devmountain.noteApp.repositories;

import com.devmountain.noteApp.entities.Favorite;
import com.devmountain.noteApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long userId);
}

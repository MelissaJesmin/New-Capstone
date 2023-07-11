package com.devmountain.noteApp.repositories;

import com.devmountain.noteApp.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}

package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.Favorite;
import com.devmountain.noteApp.entities.Game;

import java.io.Serializable;

public class FavoriteDto  implements Serializable {
    private Long id;
    private UserDto userDto;
    private GameDto gameDto;
    public FavoriteDto(Favorite favorite) {
        if (favorite.getId() != null) {
            this.id = favorite.getId();
        }

        if (favorite.getUser() != null) {
            this.userDto = new UserDto(favorite.getUser());
        }

        if (favorite.getGame() != null) {
            this.gameDto = new GameDto(favorite.getGame());
        }

    }

}
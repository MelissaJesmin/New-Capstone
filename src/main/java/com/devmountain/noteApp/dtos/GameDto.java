package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.Game;

import java.io.Serializable;

public class GameDto implements Serializable {
    private Long id;
    private String imageUrl;
    private String name;
    private String genre;
    private String platform;
    private Integer cost;
    private UserDto userDto;

    public GameDto(Game game) {
        if (game.getId()!= null) {
            this.id = game.getId();
        }

        if(game.getImageUrl()!=null) {
            this.imageUrl = game.getImageUrl();
        }

        if(game.getName()!=null) {
            this.name = game.getName();
        }

        if(game.getGenre()!=null) {
            this.genre = game.getGenre();
        }
        if(game.getPlatform()!=null) {
            this.platform = game.getPlatform();
        }
        if(game.getCost()!= null) {
            this.cost = game.getCost();
        }
    }
}

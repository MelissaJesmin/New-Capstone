package com.devmountain.noteApp.dtos;

import com.devmountain.noteApp.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto implements Serializable {
    private Long id;
    private String thumbnail;
    private String name;
    private String genre;
    private String platform;
    private Integer cost;
    private UserDto userDto;

    public GameDto(Game game) {
        if (game.getId()!= null) {
            this.id = game.getId();
        }

        if(game.getThumbnail()!=null) {
            this.thumbnail = game.getThumbnail();
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
        if (game.getUser() != null) {
            this.userDto = new UserDto(game.getUser());
        }
    }
}

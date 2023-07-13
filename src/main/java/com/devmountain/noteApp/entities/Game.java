package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.GameDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String thumbnail;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "text")
    private String genre;

    @Column(columnDefinition = "text")
    private String platform;

    @Column(columnDefinition = "int")
    private Integer cost;

    @ManyToOne
    @JsonBackReference
    private User user;


    public Game(GameDto gameDto) {
        if(gameDto.getName() != null) {
            this.name = gameDto.getName();
        }
        if(gameDto.getThumbnail() != null) {
            this.thumbnail = gameDto.getThumbnail();
        }
        if(gameDto.getGenre() != null) {
            this.genre = gameDto.getGenre();
        }
        if(gameDto.getPlatform() != null) {
            this.platform = gameDto.getPlatform();
        }
        if(gameDto.getCost() != null) {
            this.cost = gameDto.getCost();
        }
    }
}
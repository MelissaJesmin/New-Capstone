package com.devmountain.noteApp.entities;

import com.devmountain.noteApp.dtos.GameDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

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

    @Column(columnDefinition = "integer")
    private Integer cost;

    @ManyToOne
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Favorite> favorites = new HashSet<>();

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
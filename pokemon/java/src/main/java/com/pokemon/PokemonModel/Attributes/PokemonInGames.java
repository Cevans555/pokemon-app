package com.pokemon.PokemonModel.Attributes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pokemon.PokemonModel.Games.Games;

import java.util.List;

public class PokemonInGames {

    private int id;
    private String name;
    @JsonProperty("game_indices")
    private List<Games> games;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Games> getGames() {
        return games;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "PokemonGames{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", games=" + games +
                '}';
    }
}

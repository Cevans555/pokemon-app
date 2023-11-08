package com.pokemon.PokemonModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pokemon.PokemonModel.Abilities.Abilities;
import com.pokemon.PokemonModel.Games.Games;
import com.pokemon.PokemonModel.Moves.Moves;
import com.pokemon.PokemonModel.Sprites.Sprites;
import com.pokemon.PokemonModel.Stats.Stats;
import com.pokemon.PokemonModel.Types.Types;

import java.util.List;

public class PokemonDetail {

    private int id;
    private String name;
    @JsonProperty("base_experience")
    private int baseExperience;
    private int height;
    private int weight;
    private List<Abilities> abilities;
    @JsonProperty("game_indices")
    private List<Games> games;
    private List<Moves> moves;
    private Sprites sprites;
    private List<Stats> stats;
    private List<Types> types;

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

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<Games> getGames() {
        return games;
    }

    public void setGames(List<Games> games) {
        this.games = games;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "PokemonDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseExperience=" + baseExperience +
                ", height=" + height +
                ", weight=" + weight +
                ", abilities=" + abilities +
                ", games=" + games +
                ", moves=" + moves +
                ", sprites=" + sprites +
                ", stats=" + stats +
                ", types=" + types +
                '}';
    }
}

package com.pokemon.PokemonModel.Attributes;

import com.pokemon.PokemonModel.Moves.Moves;

import java.util.List;

public class PokemonMoves {

    private int id;
    private String name;
    private List<Moves> moves;

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

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "PokemonMoves{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", moves=" + moves +
                '}';
    }
}

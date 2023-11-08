package com.pokemon.PokemonModel.Attributes;

import com.pokemon.PokemonModel.Sprites.Sprites;

public class PokemonSprites {

    private int id;
    private String name;

    private Sprites sprites;

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

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    @Override
    public String toString() {
        return "PokemonSprites{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sprites=" + sprites +
                '}';
    }
}

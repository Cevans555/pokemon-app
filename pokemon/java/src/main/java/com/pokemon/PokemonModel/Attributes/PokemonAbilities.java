package com.pokemon.PokemonModel.Attributes;

import com.pokemon.PokemonModel.Abilities.Abilities;

import java.util.List;

public class PokemonAbilities {

    private int id;
    private String name;
    private List<Abilities> abilities;

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

    public List<Abilities> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "PokemonAbilities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", abilities=" + abilities +
                '}';
    }
}

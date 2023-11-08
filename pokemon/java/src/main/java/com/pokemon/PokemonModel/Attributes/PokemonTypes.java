package com.pokemon.PokemonModel.Attributes;

import com.pokemon.PokemonModel.Types.Types;

import java.util.List;

public class PokemonTypes {

    private int id;
    private String name;

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

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }
}

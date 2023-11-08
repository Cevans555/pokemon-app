package com.pokemon.PokemonModel.Attributes;

import com.pokemon.PokemonModel.Stats.Stats;

import java.util.List;

public class PokemonStats {

    private int id;
    private String name;
    private List<Stats> stats;

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

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "PokemonStats{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stats=" + stats +
                '}';
    }
}

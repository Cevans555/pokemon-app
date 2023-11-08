package com.pokemon.PokemonModel.Stats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

    @JsonProperty("base_stat")
    private int baseStat;
    private Stat stat;

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "PokemonStats{" +
                "baseStat=" + baseStat +
                ", stat=" + stat +
                '}';
    }
}

package com.pokemon.PokemonModel;

import java.util.List;

public class PokemonResponse {

    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PokemonResponse{" +
                "results=" + results +
                '}';
    }
}

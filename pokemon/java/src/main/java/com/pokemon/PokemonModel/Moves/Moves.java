package com.pokemon.PokemonModel.Moves;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Moves {

    private Move move;
    @JsonProperty("version_group_details")
    private List<VersionGroupDetails> versionGroupDetails;

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public List<VersionGroupDetails> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setVersionGroupDetails(List<VersionGroupDetails> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

    @Override
    public String toString() {
        return "PokemonMoves{" +
                "move=" + move +
                ", versionGroupDetails=" + versionGroupDetails +
                '}';
    }
}

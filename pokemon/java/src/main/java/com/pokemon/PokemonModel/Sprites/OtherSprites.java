package com.pokemon.PokemonModel.Sprites;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtherSprites {

    @JsonProperty("official-artwork")
    private OfficialArt officialArtwork;

    public OfficialArt getOfficialArtwork() {
        return officialArtwork;
    }

    public void setOfficialArtwork(OfficialArt officialArtwork) {
        this.officialArtwork = officialArtwork;
    }

    @Override
    public String toString() {
        return "OtherSprites{" +
                "officialArtwork=" + officialArtwork +
                '}';
    }
}

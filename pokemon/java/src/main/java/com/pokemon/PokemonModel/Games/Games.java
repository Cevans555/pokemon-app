package com.pokemon.PokemonModel.Games;

public class Games {

    private Version version;

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "GameParticipation{" +
                "version=" + version +
                '}';
    }
}

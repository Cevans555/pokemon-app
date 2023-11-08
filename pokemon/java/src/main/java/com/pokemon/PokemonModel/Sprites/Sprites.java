package com.pokemon.PokemonModel.Sprites;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {

    @JsonProperty("back_default")
    private String backDefault;
    @JsonProperty("back_female")
    private String backFemale;
    @JsonProperty("back_shiny")
    private String backShiny;
    @JsonProperty("back_shiny_female")
    private String backShinyFemale;
    @JsonProperty("front_default")
    private String frontDefault;
    @JsonProperty("front_female")
    private String frontFemale;
    @JsonProperty("front_shiny")
    private String frontShiny;
    @JsonProperty("front_shiny_female")
    private String frontShinyFemale;
    private OtherSprites other;

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getBackFemale() {
        return backFemale;
    }

    public void setBackFemale(String backFemale) {
        this.backFemale = backFemale;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    public String getBackShinyFemale() {
        return backShinyFemale;
    }

    public void setBackShinyFemale(String backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontFemale() {
        return frontFemale;
    }

    public void setFrontFemale(String frontFemale) {
        this.frontFemale = frontFemale;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public void setFrontShinyFemale(String frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    public OtherSprites getOther() {
        return other;
    }

    public void setOther(OtherSprites other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Sprites{" +
                "backDefault='" + backDefault + '\'' +
                ", backFemale='" + backFemale + '\'' +
                ", backShiny='" + backShiny + '\'' +
                ", backShinyFemale='" + backShinyFemale + '\'' +
                ", frontDefault='" + frontDefault + '\'' +
                ", frontFemale='" + frontFemale + '\'' +
                ", frontShiny='" + frontShiny + '\'' +
                ", frontShinyFemale='" + frontShinyFemale + '\'' +
                ", other=" + other +
                '}';
    }
}

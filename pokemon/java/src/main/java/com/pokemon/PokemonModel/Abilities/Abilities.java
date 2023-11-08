package com.pokemon.PokemonModel.Abilities;

public class Abilities {

    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "Abilities{" +
                "ability=" + ability +
                '}';
    }
}

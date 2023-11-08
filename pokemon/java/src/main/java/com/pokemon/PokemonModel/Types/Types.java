package com.pokemon.PokemonModel.Types;



public class Types {

    private TypeInfo type;

    public TypeInfo getType() {
        return type;
    }

    public void setType(TypeInfo type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Types{" +
                "type=" + type +
                '}';
    }
}

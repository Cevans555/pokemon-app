package com.pokemon.service;

import com.pokemon.PokemonModel.*;
import com.pokemon.PokemonModel.Attributes.*;

import java.util.List;

public interface PokeAPIService {

    List<Pokemon> getPokemon();
    PokemonDetail getPokemonDetailById(int id);
    PokemonAbilities getPokemonAbilitiesById(int id);
    PokemonInGames getPokemonGamesById(int id);
    PokemonMoves getPokemonMovesById(int id);
    PokemonSprites getPokemonSpritesById(int id);
    PokemonStats getPokemonStatsById(int id);
    PokemonTypes getPokemonTypesById(int id);

}

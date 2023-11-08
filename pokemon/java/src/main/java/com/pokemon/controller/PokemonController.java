package com.pokemon.controller;

import com.pokemon.PokemonModel.*;
import com.pokemon.PokemonModel.Attributes.*;
import com.pokemon.service.PokeAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/pokemon")
public class PokemonController {

    @Autowired
    PokeAPIService service;

    @GetMapping()
    public List<Pokemon> getAllPokemon(){
        return service.getPokemon();
    }

    @GetMapping("/details/{id}")
    public PokemonDetail getPokemonDetailById(@PathVariable int id){
        return service.getPokemonDetailById(id);
    }

    @GetMapping("/abilities/{id}")
    public PokemonAbilities getPokemonAbilitiesById(@PathVariable int id){
        return service.getPokemonAbilitiesById(id);
    }

    @GetMapping("/games/{id}")
    public PokemonInGames getPokemonPokemonInGamesById(@PathVariable int id){
        return service.getPokemonGamesById(id);
    }

    @GetMapping("/moves/{id}")
    public PokemonMoves getPokemonMovesById(@PathVariable int id){
        return service.getPokemonMovesById(id);
    }

    @GetMapping("/sprites/{id}")
    public PokemonSprites getPokemonSpritesById(@PathVariable int id){
        return service.getPokemonSpritesById(id);
    }

    @GetMapping("/stats/{id}")
    public PokemonStats getPokemonStatsById(@PathVariable int id){
        return service.getPokemonStatsById(id);
    }

    @GetMapping("/types/{id}")
    public PokemonTypes getPokemonTypesById(@PathVariable int id){
        return service.getPokemonTypesById(id);
    }
}

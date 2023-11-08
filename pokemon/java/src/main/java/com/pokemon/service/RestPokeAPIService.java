package com.pokemon.service;

import com.pokemon.PokemonModel.*;
import com.pokemon.PokemonModel.Attributes.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestPokeAPIService implements PokeAPIService{

    RestTemplate rt = new RestTemplate();
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon/";

    @Override
    public List<Pokemon> getPokemon() {
        PokemonResponse response = rt.getForObject(API_URL + "?offset=0&limit=1010", PokemonResponse.class);
        List<Pokemon> pokemonList = new ArrayList<>();

        for (Pokemon pokemon : response.getResults()){
            String url = pokemon.getUrl();
            int pokemonIndex = url.indexOf("pokemon");
            String pokemonString = url.substring(pokemonIndex);
            int slashIndex = pokemonString.indexOf("/");
            String number = pokemonString.substring(slashIndex + 1, pokemonString.length() - 1);
            int id = Integer.parseInt(number);
            pokemon.setId(id);
           System.out.println(pokemon);
            pokemonList.add(pokemon);
        }

        // below is a "harder" way of doing this
//        String response = rt.getForObject(API_URL, String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        List<Pokemon> pokemonList = new ArrayList<>();
//        System.out.println(response);
//        try {
//            JsonNode jsonNode = mapper.readTree(response);
//            JsonNode root = jsonNode.path("results");
//            for(int i = 0; i < root.size(); i++){
//                String name = root.path(i).path("name").asText();
//                String url = root.path(i).path("url").asText();
//                int id = i + 1;
//
//                Pokemon temp = new Pokemon();
//                temp.setId(id);
//                temp.setName(name);
//                temp.setUrl(url);
//                pokemonList.add(temp);
//            }
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
        return pokemonList;
    }

    @Override
    public PokemonDetail getPokemonDetailById(int id) {
        PokemonDetail pokemonDetail = rt.getForObject(API_URL + id, PokemonDetail.class);
//        System.out.println(pokemonDetail);
        return pokemonDetail;
    }

    @Override
    public PokemonAbilities getPokemonAbilitiesById(int id) {
        PokemonAbilities pokemonAbilities = rt.getForObject(API_URL + id, PokemonAbilities.class);
        return pokemonAbilities;
    }

    @Override
    public PokemonInGames getPokemonGamesById(int id) {
        PokemonInGames pokemonInGames = rt.getForObject(API_URL + id, PokemonInGames.class);
        return pokemonInGames;
    }

    @Override
    public PokemonMoves getPokemonMovesById(int id) {
        PokemonMoves pokemonMoves = rt.getForObject(API_URL + id, PokemonMoves.class);
        return pokemonMoves;
    }

    @Override
    public PokemonSprites getPokemonSpritesById(int id) {
        PokemonSprites pokemonSprites = rt.getForObject(API_URL + id, PokemonSprites.class);
        return pokemonSprites;
    }

    @Override
    public PokemonStats getPokemonStatsById(int id) {
        PokemonStats pokemonStats = rt.getForObject(API_URL + id, PokemonStats.class);
        return pokemonStats;
    }

    @Override
    public PokemonTypes getPokemonTypesById(int id) {
        PokemonTypes pokemonTypes = rt.getForObject(API_URL + id, PokemonTypes.class);
        return pokemonTypes;
    }

}

import axios from "axios";

export default {

    getAllPokemon() {
        return axios.get("/pokemon");
    },
    getPokemonDetailsById(id) {
        return axios.get(`/pokemon/details/${id}`);
    },
    getPokemonAbilitiesById(id) {
        return axios.get(`/pokemon/abilities/${id}`);
    },
    getPokemonInGamesById(id) {
        return axios.get(`/pokemon/Games/${id}`);
    },
    getPokemonMovesById(id) {
        return axios.get(`/pokemon/moves/${id}`);
    },
    getPokemonSpritesById(id) {
        return axios.get(`/pokemon/sprites/${id}`);
    },
    getPokemonStatsById(id) {
        return axios.get(`/pokemon/Stats/${id}`);
    },
    getPokemonTypesById(id) {
        return axios.get(`/pokemon/Types/${id}`);
    },

  }
  
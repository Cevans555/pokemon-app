<template>
    <div>
        <h2>Games</h2>
        <!-- <p>{{ pokemon.game_indices }}</p> -->
        <p v-for="games in pokemon.game_indices" :key="games">
            {{ games.version.name }}
        </p>
    </div>
</template>

<script>
import PokemonService from '../services/PokemonService.js'
export default{
    name: 'PokemonDetails',
    props: {
        id: Number, String,
    },
    data() {
        return {
            pokemon: {},
        }
    },
    created() {
        PokemonService.getPokemonInGamesById(this.id)
            .then(response => {
                this.pokemon = response.data
            })
    }
};
</script>

<style></style>
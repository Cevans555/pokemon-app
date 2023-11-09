<template>
    <div>
        <h2>{{ pokemon.name }}</h2>
        <p>Height: {{ pokemon.height }}</p>
        <p>Weight: {{ pokemon.weight }}</p>
        <!-- <p>Abilities: {{ abilities }}</p>
        <p>Moves: {{ moves }}</p>
        <p>Types: {{ types }}</p>
        <p>Games: {{ games }}</p>
        <p>Stats: {{ stats }}</p> -->
        <p>Base Experience: {{ pokemon.base_experience }}</p>
        <img v-bind:src="spriteImgFront" />
        
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
            spriteImgFront : '',
            abilities: [],
            moves: [],
            types: [],
            games: [],
            stats: [],

        }
    },
    created() {
        PokemonService.getPokemonDetailsById(this.id)
            .then(response => {
                this.pokemon = response.data
                this.spriteImgFront = response.data.sprites.other['official-artwork'].front_default
                response.data.abilities.forEach(element => {
                    this.abilities.push(element.ability.name);
                });
                response.data.moves.forEach(element => {
                    this.moves.push(element.move.name);
                });
                response.data.types.forEach(element => {
                    this.types.push(element.type.name);
                });
                response.data.game_indices.forEach(element => {
                    this.games.push(element.version.name);
                });
                response.data.stats.forEach(element => {
                    this.stats.push(element.stat.name);
                });

            })
    }
};
</script>

<style></style>
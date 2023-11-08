<template>
    <div>
        <ul>
            <li v-for="pokemon in pokemonArray" v-bind:key="pokemon.id">
                <router-link v-bind:to="{
                    name: 'pokemonDetails',
                    params: {
                        id: pokemon.id,
                    }
                }">
                    {{ pokemon.name }}
                </router-link>
            </li>
        </ul>
    </div>
</template>

<script>
import PokemonService from '../services/PokemonService.js'
export default {
    name: 'PokemonList',
    data() {
        return {
            pokemonArray: []
        }
    },
    created() {
        PokemonService.getAllPokemon()
            .then(response => {
                console.log(response)
                this.pokemonArray = response.data
            })
    }
}
</script>

<style></style>
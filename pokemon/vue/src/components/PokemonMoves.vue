<template>
    <div>
        <h2>Moves</h2>
        <!-- <p>{{ pokemon.moves }}</p> -->
        <p v-for="moves in pokemon.moves" :key="moves">
            {{ moves.move.name }}
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
        PokemonService.getPokemonMovesById(this.id)
            .then(response => {
                this.pokemon = response.data
            })
    }
};
</script>

<style></style>
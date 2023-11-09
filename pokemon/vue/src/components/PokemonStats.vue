<template>
    <div>
        <h2>Stats</h2>
        <!-- <p>{{ pokemon }}</p> -->
        <p v-for="stats in pokemon.stats" :key="stats">
            {{ stats.stat.name }} base stat: {{ stats.base_stat }}
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
        PokemonService.getPokemonStatsById(this.id)
            .then(response => {
                this.pokemon = response.data
            })
    }
};
</script>

<style></style>
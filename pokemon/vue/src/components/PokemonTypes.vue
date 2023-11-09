<template>
    <div>
        <h2>Types</h2>
        <!-- <p>{{ pokemon }}</p> -->
        <p v-for="types in pokemon.types" :key="types">
            {{ types.type.name }}
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
        PokemonService.getPokemonTypesById(this.id)
            .then(response => {
                this.pokemon = response.data
            })
    }
};
</script>

<style></style>
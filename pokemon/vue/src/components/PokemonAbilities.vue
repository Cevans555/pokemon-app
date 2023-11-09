<template>
    <div>
        <h2>Abilities</h2>
        <!-- <p>{{ pokemon.abilities }}</p> -->
        <p v-for="abilities in pokemon.abilities" :key="abilities.ability.name">
            {{ abilities.ability.name }}
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
        PokemonService.getPokemonAbilitiesById(this.id)
            .then(response => {
                this.pokemon = response.data
            })
    }
};
</script>

<style></style>
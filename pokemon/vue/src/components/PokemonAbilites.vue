<template>
    <div>
        <h2>{{ pokemon.name }}</h2>
        <p>{{ pokemon.abilities }}</p>
        <ul>
            <li>

            </li>
        </ul>
        
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
                // this.spriteImgFront = response.data.sprites.front_default
                // this.spriteImgBack = response.data.sprites.back_default
            })
    }
};
</script>

<style></style>
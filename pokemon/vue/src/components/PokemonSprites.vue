<template>
    <div id="sprites">
        <!-- <h2>Sprites</h2> -->
        <!-- {{ pokemon }} -->
        <img :src="officialArtFrontDefault" alt="Official Art Front Default">
        <!-- <p v-for="sprites in pokemon.sprites" :key="sprites">
            {{ sprites }}
        </p> -->
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
            officialArtFrontDefault: '',
        }
    },
    created() {
        PokemonService.getPokemonSpritesById(this.id)
            .then(response => {
                this.pokemon = response.data
                this.officialArtFrontDefault = this.pokemon.sprites.other['official-artwork'].front_default
            })
    }
};
</script>

<style>
img {
    width: 210px;
    height: auto;
    max-height: 175px;
    
}

#sprites {
   text-align: center;
}
</style>
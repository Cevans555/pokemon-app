<template>
    <div id="sprites">
        <img :src="image" alt="Pokemon Sprite">
    </div>
</template>

<script>
import PokemonService from '../services/PokemonService.js'
export default{
    name: 'PokemonSprites',
    props: {
        id: Number, String,
    },
    data() {
        return {
            pokemon: {},
            // officialArtFrontDefault: '',
            image: '',
            sprites: [],

        }
    },
    created() {
        PokemonService.getPokemonSpritesById(this.id)
            .then(response => {
                this.pokemon = response.data
                // this.officialArtFrontDefault = this.pokemon.sprites.other['official-artwork'].front_default
                this.sprites.push(this.pokemon.sprites.other['official-artwork'].front_default)
                this.sprites.push(this.pokemon.sprites.other['official-artwork'].front_shiny)
                this.sprites.push(this.pokemon.sprites.front_default)
                this.sprites.push(this.pokemon.sprites.back_default)
                this.sprites.push(this.pokemon.sprites.front_female)
                this.sprites.push(this.pokemon.sprites.back_female)
                this.sprites.push(this.pokemon.sprites.front_shiny)
                this.sprites.push(this.pokemon.sprites.back_shiny)
                this.sprites.push(this.pokemon.sprites.front_shiny_female)
                this.sprites.push(this.pokemon.sprites.back_shiny_female)

                this.sprites = this.sprites.filter(sprite => sprite !== null);
                this.fetchSprite();
            });
    },
    methods:{
        fetchSprite(){
            this.image = this.sprites[this.$store.state.spriteIndex]
        }
    },
    watch: {
        '$store.state.spriteIndex': 'fetchSprite',
    },
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
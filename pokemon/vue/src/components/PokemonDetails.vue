<template>
    <div id="details">
        <h2>Details</h2>
        <ul class="details-grid">
            <li>Height: {{ pokemon.height }}</li>
            <li>Weight: {{ pokemon.weight }}</li>
            <li class="experience">Base Experience: {{ pokemon.base_experience }}</li>
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
        PokemonService.getPokemonDetailsById(this.id)
            .then(response => {
                this.pokemon = response.data
            })
    }
};
</script>

<style>
#details{
   text-align: center;
   color: white;
}

#details h2{
    margin: 0;
}

.details-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);  
  list-style: none;
  padding: 0; 
  margin: 0;
}

.details-grid li {
  padding: 10px;
  text-align: center;
}

.experience {
    grid-column: span 2;
}
</style>
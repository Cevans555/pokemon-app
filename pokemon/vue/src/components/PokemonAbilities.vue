<template>
    <div id="abilities">
        <h2>Abilities</h2>
        <ul class="abilities-grid">
            <li v-for="ability in abilities" :key="ability">
                {{ ability }}
            </li>
        </ul>
    </div>
</template>

<script>
import PokemonService from '../services/PokemonService.js'
export default{
    name: 'PokemonAbilities',
    props: {
        id: Number, String,
    },
    data() {
        return {
            abilities: [],
        }
    },
    created() {
        this.fetchAbilities();
    },
    watch: {
        '$store.state.index': 'fetchAbilities',
    },
    methods: {
        fetchAbilities() {
            PokemonService.getPokemonAbilitiesById(this.id)
                .then(response => {
                    console.log(response.data.abilities);
                    this.abilities = [];
                    for (let i = this.$store.state.index; i < response.data.abilities.length; i++) {
                        this.abilities.push(response.data.abilities[i].ability.name);
                        if (this.abilities.length >= 4) {
                            break;
                        }
                    }
                });
        },
    }
};
</script>

<style>
#abilities{
   text-align: center;
   color: white;
}

#abilities h2{
    margin: 0;
}

.abilities-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);  
  list-style: none;
  padding: 0; 
  margin: 0;
}

.abilities-grid li {
  padding: 10px;
  text-align: center;
}
</style>
<template>
    <div id="games">
        <h2>Games</h2>
        <!-- <p>{{ pokemon.game_indices }}</p> -->
        <!-- <p>{{ games }}</p> -->
        <ul class="games-grid">
            <li v-for="game in games" :key="game">
                {{ game }}
            </li>
        </ul>
    </div>
</template>

<script>
import PokemonService from '../services/PokemonService.js'
export default{
    name: 'PokemonGames',
    props: {
        id: Number, String,
    },
    data() {
        return {
            games: [],
        }
    },
    created() {
        this.fetchGames();
    },
    watch: {
        '$store.state.index': 'fetchGames',
    },
    methods: {
        fetchGames() {
            PokemonService.getPokemonInGamesById(this.id)
                .then(response => {
                    this.games = [];
                    for (let i = this.$store.state.index; i < response.data.game_indices.length; i++) {
                        this.games.push(response.data.game_indices[i].version.name);
                        if (this.games.length >= 4) {
                            break;
                        }
                    }
                });
        },
    }
};
</script>

<style>
#games{
   text-align: center;
   color: white;
}

#games h2{
    margin: 0;
}

.games-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);  
  list-style: none;
  padding: 0; 
  margin: 0;
}

.games-grid li {
  padding: 10px;
  text-align: center;
}
</style>
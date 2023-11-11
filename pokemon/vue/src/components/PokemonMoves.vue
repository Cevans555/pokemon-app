<template>
    <div id="moves">
        <h2>Moves</h2>
        <ul class="moves-grid">
            <li v-for="move in moves" :key="move">
                {{ move }}
            </li>
        </ul>
    </div>
</template>

<script>
import PokemonService from '../services/PokemonService.js'
export default{
    name: 'PokemonMoves',
    props: {
        id: Number, String,
    },
    data() {
        return {
            moves: [],
        }
    },
    created() {
        this.fetchmoves();
    },
    watch: {
        '$store.state.attributeIndex': 'fetchmoves',
    },
    methods: {
        fetchmoves() {
            PokemonService.getPokemonMovesById(this.id)
                .then(response => {
                    this.moves = [];
                    for (let i = this.$store.state.attributeIndex; i < response.data.moves.length; i++) {
                        this.moves.push(response.data.moves[i].move.name);
                        if (this.moves.length >= 4) {
                            break;
                        }
                    }
                });
        },
    }
};
</script>

<style>
#moves{
   text-align: center;
   color: white;
}

#moves h2{
    margin: 0;
}

.moves-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);  
  list-style: none;
  padding: 0; 
  margin: 0;
}

.moves-grid li {
  padding: 10px;
  text-align: center;
}
</style>
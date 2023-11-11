<template>
    <div id="stats">
        <h2>Stats</h2>
        <ul class="stats-grid">
            <li v-for="(value, key) in stats" :key="key">
                {{ key }}: {{ value }}
            </li>
        </ul>
    </div>
</template>

<script>
import PokemonService from '../services/PokemonService.js'
export default {
    name: 'Pokemonstats',
    props: {
        id: Number, String,
    },
    data() {
        return {
            stats: {},
        }
    },
    created() {
        this.fetchstats();
    },
    watch: {
        '$store.state.attributeIndex': 'fetchstats',
    },
    methods: {
        fetchstats() {
            PokemonService.getPokemonStatsById(this.id)
                .then(response => {
                    console.log(response.data.stats);
                    this.stats = {};
                    for (let i = this.$store.state.attributeIndex; i < response.data.stats.length; i++) {
                        const stat = response.data.stats[i];
                        this.stats[stat.stat.name] = stat.base_stat;

                        if (Object.keys(this.stats).length >= 4) {
                            break;
                        }
                    }
                    console.log(this.stats);
                });
        },
    }
};
</script>

<style>
#stats {
    text-align: center;
    color: white;
}

#stats h2 {
    margin: 0;
}

.stats-grid {
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    list-style: none;
    padding: 0;
    margin: 0;
    white-space: nowrap;
}

.stats-grid li {
    padding: 10px;
    text-align: center;
}
</style>
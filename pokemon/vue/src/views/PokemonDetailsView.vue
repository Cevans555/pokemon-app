<template>
    <div>
        <pokemon-details v-bind:id="$route.params.id" />
        
    </div>
</template>

<script>
import PokemonDetails from '../components/PokemonDetails.vue';
export default {
    name: 'PokemonDetailsView',
    components: {
        PokemonDetails,
    }
};
</script>

<style></style>
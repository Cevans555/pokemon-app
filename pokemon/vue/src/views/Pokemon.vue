<template>
  <div>
    <h1>List of Pokemon</h1>
    <pokemon-list/>
  </div>
</template>

<script>
import PokemonList from '../components/PokemonList.vue';
export default {
    name: 'Pokemon',
    components: {
        PokemonList
    }
}
</script>

<style>
</style>

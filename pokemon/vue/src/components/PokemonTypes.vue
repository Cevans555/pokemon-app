<template>
    <div>
        <p>{{ types[i] }}</p>
    </div>
</template>

<script>
import PokemonService from '../services/PokemonService.js'
export default{
    name: 'PokemonTypes',
    props: {
        id: Number, String,
        i: Number,
    },
    data() {
        return {
            types: [],
        }
    },
    created() {
        PokemonService.getPokemonTypesById(this.id)
            .then(response => {
                response.data.types.forEach(element => {
                    this.types.push(element.type.name)
                });
                console.log(this.types)
            })
    }
};
</script>

<style></style>
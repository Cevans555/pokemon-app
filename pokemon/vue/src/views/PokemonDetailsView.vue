<template>
    <div id="pokedex">
        <div id="container">
            <!------ LEFT SIDE ------>
            <div id="left-side">
                <!-- Rounded bordure left -->
                <div id="left-side1-top-border"></div>
                <div id="left-side2-top-border"></div>
                <!-- Top left lights -->
                <div id="big-blue-light-background" class="light">
                    <div id="big-blue-light" class="light"></div>
                    <div id="big-blue-light-glint" class="light"></div>
                </div>
                <div id="little-lights">
                    <div class="light little-light red-light"></div>
                    <div class="light little-light yellow-light"></div>
                    <div class="light little-light green-light"></div>
                </div>
                <!-- Left side big screen with red lights -->
                <div id="screen-left-background">
                    <div id="screen-left-little-lights">
                        <div class="screen-left-little-red-light light"></div>
                        <div class="screen-left-little-red-light light"></div>
                    </div>
                    <!-- Screen for the Pokemon images -->
                    <div id="screen-left">
                        <pokemon-sprites v-bind:id="$route.params.id" />
                    </div>
                    <div id="screen-left-big-red-light" class="light"></div>
                    <div id="screen-left-burger">
                        <div id="screen-left-burger-inside"></div>
                    </div>
                </div>
                <!-- Console -->
                <div id="elongated-buttons">
                    <div class="elongated-button elongated-button1 clickable"></div>
                    <div class="elongated-button elongated-button2 clickable"></div>
                </div>
                <div id="rounded-button" class="clickable"></div>
                <div id="screen-left-little">
                    <h1>{{ pokemon.name }}</h1>
                </div>
                <!-- Cross used to choose the Pokemon -->
                <div id="cross">
                    <div class="cross cross-top clickable">
                        <div class="arrow arrow-top"></div>
                    </div>
                    <div class="cross cross-mid"></div>
                    <div class="cross cross-bottom clickable">
                        <div class="arrow arrow-bottom"></div>
                    </div>
                    <div class="cross cross-left clickable">
                        <div class="arrow arrow-left" onclick="previousPokemon()"></div>
                    </div>
                    <div class="cross cross-right clickable">
                        <div class="arrow arrow-right" onclick="nextPokemon()"></div>
                    </div>
                </div>
            </div>

            <!------ MIDDLE ------>
            <!-- Bindings -->
            <div class="binding">
                <div class="hinge hinge1"></div>
                <div class="hinge hinge2"></div>
                <div class="hinge hinge3"></div>
            </div>

            <!------ RIGHT SIDE ------>
            <div id="right-side">
                <!-- Rounded bordure right -->
                <div id="round-bordure-right-side"></div>
                <!-- Right side screen -->
                <div id="screen-right">
                    <pokemon-abilities v-bind:id="this.id" v-bind:index="this.index" v-if="displayAbilities === true" />
                    <pokemon-games v-bind:id="this.id" v-bind:index="this.index" v-if="displayGames === true" />
                    <pokemon-moves v-bind:id="this.id" v-bind:index="this.index" v-if="displayMoves === true" />
                    <pokemon-details v-bind:id="this.id" v-bind:index="this.index" v-if="displayDetails === true" />
                    <pokemon-stats v-bind:id="this.id" v-bind:index="this.index" v-if="displayStats === true" />
                </div>
                <!-- Right side keyboard -->
                <div id="keyboard">
                    <div class="key clickable" @click="TurnDisplayAbilitiesOn"></div>
                    <div class="key clickable" @click="TurnDisplayGamesOn"></div>
                    <div class="key clickable" @click="TurnDisplayMovesOn"></div>
                    <div class="key clickable" @click="TurnDisplayStatsOn"></div>
                    <div class="key clickable" @click="TurnDisplayDetailsOn"></div>
                    <div class="key clickable"></div>
                    
                </div>
                <!-- Right elongated lights -->
                <div id="elongated-lights">
                    <div class="key light"></div>
                    <div class="key light"></div>
                </div>
                <!-- Right side yellow light -->
                <div id="right-side-yellow-light" class="light"></div>
                <!-- Right side white buttons -->
                <div id="white-buttons">
                    <div class="key clickable" @click="prevIndex"></div>
                    <div class="key clickable" @click="nextIndex"></div>
                </div>
                <!-- Right side grey buttons -->
                <div id="grey-buttons">
                    <div class="key">
                        <pokemon-types v-bind:id="this.id" :i="0"/>
                    </div>
                    <div class="key">
                        <pokemon-types v-bind:id="this.id" :i="1"/>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="key clickable" @click="nextIndex"></div>
    </div>
</template>

<script>
import PokemonDetails from '../components/PokemonDetails.vue';
import PokemonAbilities from '../components/PokemonAbilities.vue';
import PokemonGames from '../components/PokemonGames.vue';
import PokemonMoves from '../components/PokemonMoves.vue';
import PokemonTypes from '../components/PokemonTypes.vue';
import PokemonStats from '../components/PokemonStats.vue';
import PokemonSprites from '../components/PokemonSprites.vue';
import PokemonService from '../services/PokemonService.js'
export default {
    name: 'PokemonDetailsView',
    components: {
        PokemonDetails,
        PokemonAbilities,
        PokemonGames,
        PokemonMoves,
        PokemonTypes,
        PokemonStats,
        PokemonSprites,
    },
    data() {
        return {
            pokemon: {},
            id: this.$route.params.id,
            index: this.$store.state.index,
            displayAbilities: false,
            displayGames: false,
            displayMoves: false,
            displayDetails: true,
            displayStats: false,
        }
    },
    created() {
        PokemonService.getPokemonDetailsById(this.id)
            .then(response => {
                this.pokemon = response.data
            })
    },
    methods: {
        nextIndex() {
            this.$store.commit('NEXT_INDEX')
            console.log(this.$store.state.index)
        },
        prevIndex() {
            this.$store.commit('PREV_INDEX')
            console.log(this.$store.state.index)
        },
        TurnDisplayAbilitiesOn() {
            this.displayAbilities = true;
            this.displayGames = false;
            this.displayMoves = false;
            this.displayDetails = false;
            this.displayStats = false;
        },
        TurnDisplayGamesOn() {
            this.displayAbilities = false;
            this.displayGames = true;
            this.displayMoves = false;
            this.displayDetails = false;
            this.displayStats = false;
        },
        TurnDisplayMovesOn() {
            this.displayAbilities = false;
            this.displayGames = false;
            this.displayMoves = true;
            this.displayDetails = false;
            this.displayStats = false;
        },
        TurnDisplayDetailsOn() {
            this.displayAbilities = false;
            this.displayGames = false;
            this.displayMoves = false;
            this.displayDetails = true;
            this.displayStats = false;
        },
        TurnDisplayStatsOn() {
            this.displayAbilities = false;
            this.displayGames = false;
            this.displayMoves = false;
            this.displayDetails = false;
            this.displayStats = true;
        },

    }
};
</script>

<style>
#container {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
}

#left-side,
#right-side {
    background-color: #C10C0C;
    position: relative;
    width: 380px;
}


/* Class for all the buttons */

.clickable {
    cursor: pointer;
}

.elongated-button:active,
#rounded-button:active,
#cross .cross:active,
#keyboard .key:active,
#white-buttons .key:active {
    box-shadow: -1px 2px 10px 5px rgba(0, 0, 0, 0.3) inset;
}


/* Class for all the lights */

.light {
    border-radius: 50px;
    border: 1px solid #4d4d4d;
}


/*------ LEFT SIDE ------*/

#left-side {
    box-shadow: -5px 5px 0px 5px rgba(96, 6, 6, 1);
    height: 600px;
    border-radius: 20px 0 0 20px;
}


/* Rounded bordure left */

#left-side1-top-border {
    width: 160px;
    height: 60px;
    position: absolute;
    z-index: 2;
    border-bottom: 2px solid rgba(96, 6, 6, 1);
    border-right: 2px solid rgba(96, 6, 6, 1);
    top: 50px;
    left: 30px;
    -webkit-transform: skew(-50deg);
    tranform: skew(-50deg);
    box-shadow: 6px 4px 1px 0px rgba(96, 6, 6, 1);
}

#left-side2-top-border {
    width: 155px;
    height: 2px;
    position: absolute;
    border-bottom: 2px solid rgba(96, 6, 6, 1);
    top: 48px;
    left: 226px;
    box-shadow: -1px 3px 2px 0px rgba(96, 6, 6, 1);
}


/* Top left lights */

#big-blue-light-background {
    background-color: #ffffff;
    height: 60px;
    width: 60px;
    position: relative;
    top: 25px;
    left: 25px;
}

#big-blue-light {
    background-image: radial-gradient(#ffffff, #63e6f7, #24d7ed 60%);
    height: 50px;
    width: 50px;
    position: relative;
    top: 5px;
    left: 5px;
    border: 0;
}

#big-blue-light-glint {
    height: 15px;
    width: 25px;
    position: absolute;
    top: 12px;
    left: 18px;
    border: 0;
    background-color: rgba(255, 255, 255, 0.5);
}

#little-lights {
    position: absolute;
    top: 22px;
    left: 100px;
}

#little-lights .little-light {
    display: inline-block;
    float: left;
    height: 20px;
    width: 20px;
    margin-right: 10px;
}

#little-lights .red-light {
    background: radial-gradient(#ffffff, #C10C0C, #8a0606 60%);
}

#little-lights .yellow-light {
    background: radial-gradient(#ffffff, #e8c817, #8c7c07 60%);
}

#little-lights .green-light {
    background: radial-gradient(#ffffff, #00ff15, #039c10 60%);
}


/* Left side big screen with red lights */

#screen-left-background {
    background-color: #DEDEDE;
    height: 250px;
    width: 280px;
    border-radius: 10px;
    position: relative;
    left: 50px;
    top: 100px;
    box-shadow: 1px 1px 3px 2px rgba(0, 0, 0, 0.5);
}

#screen-left-little-lights {
    position: relative;
    top: 15px;
    left: 120px;
}

#screen-left-little-lights .screen-left-little-red-light {
    display: inline-block;
    float: left;
    background-color: #C10C0C;
    height: 6px;
    width: 6px;
    margin-right: 15px;
    border: 1px solid #474747;
}

/* Screen for the Pokemon images */

#screen-left {
    background-color: #4a4a4a;
    box-shadow: -1px 2px 10px 5px rgba(0, 0, 0, 0.3) inset;
    height: 175px;
    width: 220px;
    border-radius: 10px;
    position: relative;
    left: 30px;
    top: 35px;
}

/* #screen-left-image {
    width: 210px;
    height: auto;
    max-height: 160px;
} */

#screen-left-big-red-light {
    background-color: #C10C0C;
    height: 15px;
    width: 15px;
    position: relative;
    top: 48px;
    left: 30px;
    animation: winkLight 1s infinite;
}

@keyframes winkLight {
    0% {
        background-color: #C10C0C;
    }

    100% {
        background-color: #8a0606;
    }
}


#screen-left-burger {
    border-top: 1px solid #4a4a4a;
    border-bottom: 1px solid #4a4a4a;
    height: 15px;
    width: 30px;
    position: absolute;
    right: 31px;
    bottom: 10px;
}

#screen-left-burger-inside {
    border-top: 1px solid #4a4a4a;
    border-bottom: 1px solid #4a4a4a;
    height: 5px;
    width: 30px;
    position: absolute;
    top: 4px;
}


/* Console */

#elongated-buttons {
    position: relative;
    top: 130px;
    left: 113px;
}

.elongated-button {
    width: 50px;
    height: 6px;
    display: inline-block;
    border-radius: 10px;
    margin-right: 20px;
    border: 1px solid #474747;
}

.elongated-button1 {
    background-color: red;
    box-shadow: -2px 2px 0px 0px rgba(96, 6, 6, 1);
}

.elongated-button2 {
    background-color: rgba(40, 170, 253, 1);
    box-shadow: -2px 2px 0px 0px rgb(1, 60, 86);
}

#rounded-button {
    position: relative;
    top: 120px;
    left: 40px;
    width: 40px;
    height: 40px;
    display: inline-block;
    border-radius: 50px;
    background-color: #424141;
    box-shadow: -2px 2px 0px 0px #292929;
}


/* Left side little screen */

#screen-left-little {
    background-color: #51AE5F;
    box-shadow: -1px 2px 10px 3px rgba(0, 0, 0, 0.3) inset;
    height: 80px;
    width: 150px;
    border-radius: 10px;
    position: relative;
    left: 100px;
    top: 105px;
    display: flex;
    align-items: center;
    justify-content: center;
}

#screen-left-little h1 {
    margin: 0;
    text-align: center;
    white-space: nowrap;
    width: 100%;
    overflow: hidden;
    text-overflow: ellipsis;
    font-size: 1.5rem;
}

/* Directionnal cross used to choose the Pokemon */

#cross {
    position: relative;
    left: 300px;
    top: 20px;
    width: 150px;
    height: 150px;
}

#cross .cross {
    height: 28px;
    width: 28px;
    position: absolute;
    background-color: #424141;
}

#cross .cross-top {
    border-radius: 5px 5px 0 0;
    box-shadow: -3px 2px 0px 0px #292929;
}

#cross .cross-mid {
    top: 28px;
    background: radial-gradient(circle, rgba(66, 65, 65, 1) 0%, rgba(56, 55, 55, 1) 50%, rgba(66, 65, 65, 1) 100%);
}

#cross .cross-bottom {
    top: 56px;
    border-radius: 0 0 5px 5px;
    box-shadow: -2px 1px 0px 1px #292929;
}

#cross .cross-left {
    left: -28px;
    top: 28px;
    border-radius: 5px 0 0 5px;
    box-shadow: -1px 2px 0px 1px #292929;
}

#cross .cross-right {
    left: 28px;
    top: 28px;
    border-radius: 0 5px 5px 0;
    box-shadow: 0px 3px 0px 0px #292929;
}

.arrow {
    display: inline-block;
    height: 0;
    width: 0;
    position: relative;
}

.arrow-top {
    top: 4px;
    left: 5px;
    border-right: 8px solid transparent;
    border-bottom: 15px solid #333232;
    border-left: 8px solid transparent;
}

.arrow-bottom {
    top: 10px;
    left: 5px;
    border-top: 15px solid #333232;
    border-right: 8px solid transparent;
    border-left: 8px solid transparent;
}

.arrow-left {
    top: 7px;
    left: 3px;
    border-right: 15px solid #333232;
    border-top: 8px solid transparent;
    border-bottom: 8px solid transparent;
}

.arrow-right {
    top: 7px;
    left: 9px;
    border-left: 15px solid #333232;
    border-bottom: 8px solid transparent;
    border-top: 8px solid transparent;
}


/*------ MIDDLE ------*/


/* Bindings */

.binding {
    height: 600px;
    width: 50px;
    border-left: 1px solid rgba(96, 6, 6, 1);
    border-right: 1px solid rgba(96, 6, 6, 1);
    box-shadow: 0px 10px 0px 0 rgba(96, 6, 6, 1);
    background: rgb(193, 12, 12);
    background: linear-gradient(90deg, rgba(193, 12, 12, 1) 0%, rgba(218, 95, 95, 1) 35%, rgba(193, 12, 12, 1) 58%, rgba(96, 6, 6, 1) 100%);
}

.hinge {
    height: 50px;
    width: 50px;
    position: relative;
    background: rgb(193, 12, 12);
    background: linear-gradient(90deg, rgba(193, 12, 12, 1) 0%, rgba(218, 95, 95, 1) 35%, rgba(193, 12, 12, 1) 58%, rgba(96, 6, 6, 1) 100%);
    border-bottom: 1px solid rgba(96, 6, 6, 1);
    border-top: 1px solid rgba(96, 6, 6, 1);
}

.hinge2 {
    top: 50px;
}

.hinge3 {
    top: 445px;
}


/*------ RIGHT SIDE ------*/

#right-side {
    border-radius: 0 20px 20px 0;
    box-shadow: 0 10px 0px 0px rgba(96, 6, 6, 1);
    height: 550px;
    top: 25px;
}


/* Rounded bordure right  */

#round-bordure-right-side {
    width: 250px;
    height: 60px;
    background: #ffffff;
    position: absolute;
    top: 0;
    right: -50px;
    -webkit-transform: skew(50deg);
    tranform: skew(50deg);
}


/* Right side screen */

#screen-right {
    background-color: #4a4a4a;
    height: 100px;
    width: 280px;
    border-radius: 10px;
    position: relative;
    left: 50px;
    top: 110px;
    padding: 15px;
    box-shadow: -1px 2px 10px 5px rgba(0, 0, 0, 0.3) inset;
}

#screen-right p {
    margin: 0;
    padding-bottom: 10px;
    width: 100px;
    color: #ffffff;
}

#screen-right #pokemon-title-p {
    text-align: center;
    width: 100%;
    padding-bottom: 30px;
    font-weight: bold;
}

#screen-right .pokemon-stats-left {
    float: left;
    padding-left: 30px;
}

#screen-right .pokemon-stats-right {
    float: right;
}

/* Right side keyboard */

#keyboard {
    height: 90px;
    width: 280px;
    position: relative;
    top: 140px;
    left: 50px;
    justify-content: space-between;
    align-items: center;
    display: flex;
    flex-wrap: wrap;
}

#keyboard .key {
    width: 75px;
    height: 42px;
    border-radius: 10px;
    background: linear-gradient(180deg, rgba(40, 170, 253, 1) 0%, rgba(85, 184, 247, 1) 50%, rgba(40, 170, 253, 1) 100%);
    box-shadow: -2px 2px 0px 0px rgb(1, 60, 86);
}


/* Right elongated lights */

#elongated-lights {
    position: relative;
    top: 150px;
    left: 232px;
}

#elongated-lights .key {
    width: 45px;
    height: 6px;
    display: inline-block;
    border-radius: 10px;
    background-color: #4a4a4a;
}


/* Right side yellow light */

#right-side-yellow-light {
    background: radial-gradient(#ffffff 5%, #ffd662, #ffa600 60%);
    height: 30px;
    width: 30px;
    position: relative;
    top: 190px;
    left: 300px;
}


/* Right side white buttons */

#white-buttons {
    position: relative;
    top: 150px;
    left: 50px;
}

#white-buttons .key {
    width: 60px;
    height: 42px;
    display: inline-block;
    border-radius: 10px;
    background-color: #DEDEDE;
    box-shadow: -2px 2px 0px 0px rgb(1, 60, 86);
}


/*  Right side grey buttons */

#grey-buttons {
    position: relative;
    top: 180px;
    width: 280px;
    left: 50px;
    display: flex;
    justify-content: space-between;
}

#grey-buttons .key {
    width: 130px;
    height: 42px;
    border-radius: 10px;
    background-color: #4a4a4a;
    border: 1px solid #292929;
    box-shadow: -1px 2px 10px 5px rgba(0, 0, 0, 0.3) inset;
}

#grey-buttons p {
    margin: 12px;
    text-align: center;
    color: #ffffff;
}</style>
package com.pokemon.PokemonModel.Moves;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VersionGroupDetails {

    @JsonProperty("level_learned_at")
    private int levelLearned;
    @JsonProperty("move_learn_method")
    private MoveLearnMethod moveLearnMethod;
    @JsonProperty("version_group")
    private VersionGroup versionGroup;

    public int getLevelLearned() {
        return levelLearned;
    }

    public void setLevelLearned(int levelLearned) {
        this.levelLearned = levelLearned;
    }

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        return "VersionGroupDetails{" +
                "levelLearned=" + levelLearned +
                ", moveLearnMethod=" + moveLearnMethod +
                ", versionGroup=" + versionGroup +
                '}';
    }
}

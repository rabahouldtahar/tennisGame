package com.onepoint.tenisgame.model;

public class Player {
    private String name;
    private Integer gameScore;
    private Integer setScore;
    private Integer setWon;
    private Integer tieBreakScore;
    private boolean advantage;


    public Player(String name) {
        this.name = name;
        this.gameScore = 0;
        this.setScore = 0;
        this.setWon = 0;
        this.tieBreakScore = 0;
        this.advantage = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGameScore() {
        return gameScore;
    }

    public void setGameScore(Integer gameScore) {
        this.gameScore = gameScore;
    }

    public boolean isAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }

    public Integer getSetScore() {
        return setScore;
    }

    public void setSetScore(Integer setScore) {
        this.setScore = setScore;
    }

    public Integer getTieBreakScore() {
        return tieBreakScore;
    }

    public void setTieBreakScore(Integer tieBreakScore) {
        this.tieBreakScore = tieBreakScore;
    }

    public Integer getSetWon() {
        return setWon;
    }

    public void setSetWon(Integer setWon) {
        this.setWon = setWon;
    }

    public void reset() {
        setGameScore(0);
        setAdvantage(false);
    }

    @Override
    public String toString() {
        return name + ":" + setScore;
    }
}

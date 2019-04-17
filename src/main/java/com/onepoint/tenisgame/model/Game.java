package com.onepoint.tenisgame.model;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {
    private Player p1;
    private Player p2;
    private boolean deuce;
    private static List<Integer> scores = Arrays.asList(0, 15, 30, 40);

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.deuce = false;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public boolean isDeuce() {
        return deuce;
    }

    public void setDeuce(boolean deuce) {
        this.deuce = deuce;
    }

    public Player start() {
        Player player;
        List<Player> players = Arrays.asList(p1, p2);
        Random random = new Random();
        while (true) {
            player = players.get(random.nextInt(players.size()));
            try {
                if (isDeuce() && !player.isAdvantage()) {
                    setDeuce(false);
                    player.setAdvantage(true);
                } else if (player.isAdvantage()) {
                    break;
                } else {
                    p1.setAdvantage(false);
                    p2.setAdvantage(false);
                    Integer index = scores.indexOf(player.getGameScore());
                    player.setGameScore(scores.get(index + 1));
                }
                // to uncomment to show game details
                //System.out.println(this);
            } catch (IndexOutOfBoundsException e) {
                if (p1.getGameScore() == 40 && p2.getGameScore() == 40) {
                    setDeuce(true);
                    // to uncomment to show game details
                    //System.out.println("==DEUCE==");
                    //System.out.println(this);
                    //System.out.println("=========");
                } else {
                    break;
                }
            }
        }
        System.out.println(this);
        return player;
    }

    @Override
    public String toString() {
        return
                p1.getName() + ":" + p1.getGameScore() + (p1.isAdvantage() ? " (adv)" : "") + "\n"
                        + p2.getName() + ":" + p2.getGameScore() + (p2.isAdvantage() ? " (adv)" : "");
    }
}

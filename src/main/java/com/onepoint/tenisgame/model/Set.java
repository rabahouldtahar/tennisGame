package com.onepoint.tenisgame.model;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Set {
    private Player p1;
    private Player p2;

    public Set(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Player start() {
        p1.setSetScore(0);
        p2.setSetScore(0);
        Player p = null;
        while (true) {
            Game game = new Game(p1, p2);
            p1.reset();
            p2.reset();
            p = game.start();
            p.setSetScore(p.getSetScore() + 1);
            if (p1.getSetScore() == 6 && p2.getSetScore() == 6) {
                System.out.println(this);
                this.tieBreak(p1, p2);
                System.out.println(this);
                break;
            } else if ((p.getSetScore() == 6 || p.getSetScore() == 7) && (Math.abs(p1.getSetScore() - p2.getSetScore()) > 1)) {
                System.out.println(this);
                break;
            }
            // to uncomment to show set details
            System.out.println(this);
        }
        return p;
    }

    private Player tieBreak(Player p1, Player p2) {
        System.out.println("<<<<<<<<<<<<<< Tie-break >>>>>>>>>>>>>>>>>>>>>>");
        List<Player> players = Arrays.asList(p1, p2);
        Player player;
        Random random = new Random();
        p1.setTieBreakScore(0);
        p2.setTieBreakScore(0);
        while (true) {
            player = players.get(random.nextInt(players.size()));
            player.setTieBreakScore(player.getTieBreakScore() + 1);

            // Security pour infini loop
            if (player.getTieBreakScore() > 20) {
                player.setSetScore(player.getSetScore() + 1);
                break;
            } else if (player.getTieBreakScore() > 5 && (Math.abs(p1.getTieBreakScore() - p2.getTieBreakScore()) > 1)) {
                player.setSetScore(player.getSetScore() + 1);
                break;
            }
        }
        System.out.println("            " + p1.getName() + ":" + p1.getTieBreakScore());
        System.out.println("            " + p2.getName() + ":" + p2.getTieBreakScore());
        return player;
    }

    @Override
    public String toString() {
        return "       " + p1.getName() + ":" + p1.getSetScore() + "\n" +
                "       " + p2.getName() + ":" + p2.getSetScore()+ "\n";
    }
}

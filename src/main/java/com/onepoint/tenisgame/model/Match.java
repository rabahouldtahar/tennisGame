package com.onepoint.tenisgame.model;

public class Match {
    private Player player1;
    private Player player2;
    private int setNumber;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.setNumber = 3;
    }

    public Match(Player player1, Player player2, int setNumber) {
        this.player1 = player1;
        this.player2 = player2;
        this.setNumber = setNumber;
    }

    public void start() {
        if(this.setNumber % 2 == 0)
            throw new NumberFormatException("Set count must be odd");
        for (int i = 1; i <= this.setNumber; i++) {
            System.out.println("===============================SET " + i + " ====================================");
            Set set = new Set(player1, player2);
            Player player = set.start();
            player.setSetWon(player.getSetWon() + 1);
            if (player.getSetWon() > (this.setNumber / 2)) {
                System.out.println("=========================================================");
                System.out.println(player.getName() + " won the match");
                break;
            }
        }
    }
}

package com.onepoint.tenisgame;

import com.onepoint.tenisgame.model.Game;
import com.onepoint.tenisgame.model.Match;
import com.onepoint.tenisgame.model.Player;
import com.onepoint.tenisgame.model.Set;

public class TennisGameApp {
    public static void main(String args[]) {
        Player player1 = new Player("Rabah");
        Player player2 = new Player("OnePoint");

        /**
         * Match test
         * */
        Match match = new Match(player1, player2, 4);
        match.start();

        /**
         * Set test
         * */
        //Set set = new Set(player1, player2);
        //set.start();

        /**
         * Game test
         * */
        //Game game = new Game(player1, player2);
        //game.start();
    }
}

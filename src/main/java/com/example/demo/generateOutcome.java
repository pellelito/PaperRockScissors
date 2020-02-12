package com.example.demo;

import java.io.IOException;

public class generateOutcome {
	public static String generateOutcome(String player2Choice, String player1Choice) throws IOException {
	    String winner="";
	    //System.out.println("Player 1 chose: " + player1Choice);
	    //System.out.println("Player 2 chose: " + player2Choice);

	    if (player2Choice.equals(player1Choice)) {
	       winner = "It's a draw";
	       ScoreKeeper.setResult("/ties");
	    } else {
	        boolean playerWon = false;
		    if (player2Choice.equals("ROCK")) {
		       if (player1Choice.equals("PAPER")) {
		           playerWon = true;
		       }
		        else  playerWon = false;
		    } else if (player2Choice.equals("PAPER")) {
		       if (player1Choice.equals("SCISSORS")) {
		           playerWon = true;
		       }
		        else playerWon = false;
		    } else if (player2Choice.equals("SCISSORS")) {
		        if (player1Choice.equals("ROCK")) {
		            playerWon = true;
		        }
		        else playerWon = false;
		    }
		    if (playerWon) {
		        winner = "Player 1 won";
		        ScoreKeeper.setResult("/wins");
		    }
		    else {
		        winner ="Player 2 won";
		        ScoreKeeper.setResult("/losses");
		    }
	}
	    return winner;
	}
}

package com.example.demo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller  
@RestController
public class Game {
	public String player1Choice ="no";
	public String player2Choice ="no";
	
//using get method  
	@RequestMapping(method = RequestMethod.GET, path = "/game")
	public String game(String PlayerChoice) throws IOException {
		player2Choice = cpuChoice.generateCPUChoice();
		String winner = generateOutcome.generateOutcome(PlayerChoice, player2Choice);
		player1Choice ="no";
		player2Choice ="no";
		return winner + "<br><br>" + getScoreBean();
	}
	@RequestMapping(method = RequestMethod.GET, path = "/game1")
	public String game1(String Player1Choice) throws IOException {		
		String winner = "Player 2 not ready yet!";
		player1Choice = Player1Choice;
		if (player2Choice!="no") {
			winner = generateOutcome.generateOutcome(player1Choice, player2Choice);
			player1Choice ="no";
			player2Choice ="no";
				}
			return winner + "<br><br>" + getScoreBean();
	}
	@RequestMapping(method = RequestMethod.GET, path = "/game2")
	public String game2(String Player2Choice) throws IOException {		
	String winner = "Player 1 not ready yet!";
	player2Choice = Player2Choice;
	if (player1Choice!="no") {
		winner = generateOutcome.generateOutcome(player1Choice, player2Choice);
		player1Choice ="no";
		player2Choice ="no";
			}
		return winner + "<br><br>" + getScoreBean();
	} 
//using post method
	@RequestMapping(method = RequestMethod.POST, path = "/reset")
	public String reset(int zero) {
		ScoreKeeper.reset(zero);
		return getScoreBean();
	} 
	 @RequestMapping(method = RequestMethod.POST, path = "/score/wins")
	//OBSi post behöver du skicka värde ifrån ex form
	public int updateWins() {
		ScoreKeeper.WINS++;
		return ScoreKeeper.WINS;
	}
	@RequestMapping(method = RequestMethod.POST, path = "/score/losses")
	//OBSi post behöver du skicka värde ifrån ex form
	public int updateLosses() {
		ScoreKeeper.LOSSES++;
		return ScoreKeeper.LOSSES;
	}
	@RequestMapping(method = RequestMethod.POST, path = "/score/ties")
	//OBSi post behöver du skicka värde ifrån ex form
	public int updateTies() {
		ScoreKeeper.TIES++;
		return ScoreKeeper.TIES;
	} 
	@RequestMapping(method = RequestMethod.GET, path = "/score", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getScoreBean() {
		String pattern = "{\"Player 1\":\"%s\", \"Player 2\":\"%s\", \"ties\": \"%s\"}";
		return String.format(pattern, ScoreKeeper.WINS, ScoreKeeper.LOSSES, ScoreKeeper.TIES);
	}
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String getTime() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now();  
		  
		return dtf.format(now);
	}
}
package com.example.demo;

import java.util.concurrent.ThreadLocalRandom;

public class cpuChoice {
	
	public static String generateCPUChoice() {
		String cpuChoice = null;
	    int randomInt = ThreadLocalRandom.current().nextInt(1, 4);
	    switch (randomInt) {
	        case 1:
	            cpuChoice = "ROCK";
	            break;
	        case 2:
	            cpuChoice = "PAPER";
	            break;
	        case 3:
	            cpuChoice = "SCISSORS";
	            break;
	    }
	    return cpuChoice;
	}
}

package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ScoreKeeper {
	
	//Bör vara privata och använda getter & Setters
	public static int WINS, LOSSES, TIES;
	
	public static void setResult(String update) throws IOException {
		 
		URL url = new URL("http://localhost:8080/score" + update);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		con.setDoOutput(true); 
		  
        OutputStream out = con.getOutputStream(); 
        InputStream ip = con.getInputStream(); 
        //System.out.println(url);
        
        con.disconnect();
	}
	public static void reset(int zero) {
		ScoreKeeper.WINS = zero;
		ScoreKeeper.LOSSES = zero;
		ScoreKeeper.TIES = zero;
	}
}


package org.project.gamescreen;

import java.io.Serializable;

public class Player implements Serializable{

	private String name;
	private int highScore;
	private int nUSA;
	private int nUSSR;
	private Country country;
	
	//Constructor
	public Player(){
		name = "unknown";
		highScore = 0;
		nUSA = -1;
		nUSSR = -1;
	}

	//Getters and Setters
	
	
	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}

	public int getnUSA() {
		return nUSA;
	}

	public void setnUSA(int nUSA) {
		this.nUSA = nUSA;
	}

	public int getnUSSR() {
		return nUSSR;
	}

	public void setnUSSR(int nUSSR) {
		this.nUSSR = nUSSR;
	}
	
	//Other functions
	public void addUSA(){
	
		//Not sure what this does
		
	}
	
	public void addUSSR(){
		
		//Not sure what this does
		
	}
	
	public void getScore(Country enemy){
		
		int score = 0;
		score = score + enemy.getStats().getPopulationLost();
		score = score + (int)(enemy.getStats().getResourcesLost() * 1.5);
		score = score - this.country.getStats().getTurns();
		
		if (this.highScore < score){
			this.highScore = score;
		}
		
	}
	
	
}

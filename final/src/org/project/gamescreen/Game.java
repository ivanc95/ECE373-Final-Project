package org.project.gamescreen;

import org.classes.Player;
import java.io.*;
import java.util.*;

public class Game implements Serializable{
	
	private ArrayList<Player> playerList;
	public Country c1;
	public Country c2;
	private HighScore highScore;
	private Statistics stats;
	private Random rand;
	private boolean newStart;
	
	public Country getC1() {
		return c1;
	}

	public void setC1(Country c1) {
		this.c1 = c1;
	}

	public Country getC2() {
		return c2;
	}

	public void setC2(Country c2) {
		this.c2 = c2;
	}

	public Game(){
		
		rand = new Random();
		
		c1 = new Country();
		c1.setName("USA");
	
		
		c2 = new Country();
		c2.setName("USSR");
		
		highScore = new HighScore();

	}

	//Getters and Setters
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public HighScore getHighScore() {
		return highScore;
	}

	public void setHighScore(HighScore highScore) {
		this.highScore = highScore;
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}
	
	//will generate missiles based on population and resources for each country c1 and c2, call this after each round.
	public void roundOver(){
		
		for (int i = 0; i < c1.getCityList().size(); i++){
			c1.getCityList().get(i).missileGeneration();
		}
		
		for (int i = 0; i < c2.getCityList().size(); i++){
			c2.getCityList().get(i).missileGeneration();
		}
		
	}
	
	 
		public static void saveData(Game u){
			
			
			FileOutputStream fileOut = null;
			ObjectOutputStream objOut= null;

			try 
			{
				fileOut = new FileOutputStream( "Game.ser" );		//the Employee object makes its way to serial data in the file Employee.ser
				objOut = new ObjectOutputStream(fileOut);
				objOut.writeObject(u);
				objOut.close();
				fileOut.close();
		     }	
			
			catch(IOException i)
		    {
				i.printStackTrace();
		    }		
	 	}
		
		public static Game loadData()
		{	
			FileInputStream fileIn = null;
			ObjectInputStream objIn = null;
			Game univ2 = null;
				
			try
			{
				fileIn = new FileInputStream("Game.ser");
				objIn = new ObjectInputStream(fileIn);
				univ2 = (Game) objIn.readObject();
				objIn.close();
				fileIn.close();
			}
			catch(IOException i)
			{
				i.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}  
			return univ2;
		}
		
		public void assignPlayerUSA(Player player1){
			
			player1.setCountry(c1);
			c1.setPlayer(player1);
			
		}
		
		public void assignPlayerUSSR(Player player2){
			
			player2.setCountry(c2);
			c2.setPlayer(player2);
		}
		
		public void newStartGame(){
			
			
			c1.reset();
			c2.reset();
			stats = new Statistics();
			
		}
		
		public void endGame(){
			
			this.c1.getPlayer().getScore(c2);
			this.c2.getPlayer().getScore(c1);
			
			this.highScore.addPlayer(c1.getPlayer());
			this.highScore.addPlayer(c2.getPlayer());
			
		}
}

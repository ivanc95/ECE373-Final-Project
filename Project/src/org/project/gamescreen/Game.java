package org.project.gamescreen;

import java.io.*;
import java.util.*;

public class Game implements Serializable{
	
	private ArrayList<Player> playerList;
	private Country c1;
	private Country c2;
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
	
	  public static void main(String[] args)
	   {
		  
		 boolean end = false;
		 Game g = new Game();
		 
		 City ny = new City(g.c1);
		 ny.setName("New York");
		 
		 City mc = new City(g.c2);
		 mc.setName("Moscow");
		 
		 g.c1.addCity(ny);
		 g.c2.addCity(mc);
		 
		 Player jim = new Player();
		 jim.setName("Jim");
		 Player phil = new Player();
		 phil.setName("Phil");
	
		 g.assignPlayerUSA(jim);
		 g.assignPlayerUSSR(phil);
		 
	     System.out.println("Initial Values:");
	     System.out.println("");
	     System.out.println("USA Missiles: " + g.c1.getMissiles());
	     System.out.println("USA-New York Population: " + g.c1.getCityList().get(0).getPopulation());
	     System.out.println("USA-New York Resources: " + g.c1.getCityList().get(0).getResources());
	     System.out.println("");
	     System.out.println("USSR Missiles: " + g.c2.getMissiles());
	     System.out.println("USSR-Moscow Population: " + g.c2.getCityList().get(0).getPopulation());
	     System.out.println("USSR-Moscow Resources: " + g.c2.getCityList().get(0).getResources());
	     System.out.println("");
	     
	     
	     g.c1.playerTurn(1, g.c1.getMissiles() / 2, g.c2.getCityList().get(0));
	     g.c2.playerTurn(2, g.c2.getMissiles() / 2, g.c1.getCityList().get(0));
	     
	     System.out.println("");
	     System.out.println("USA attacks Resources with half of missiles, USSR attack Population with half of missiles");
	     System.out.println("");
	     System.out.println("USA Missiles: " + g.c1.getMissiles());
	     System.out.println("USA-New York Population: " + g.c1.getCityList().get(0).getPopulation());
	     System.out.println("USA-New York Resources: " + g.c1.getCityList().get(0).getResources());
	     System.out.println("");
	     System.out.println("USSR Missiles: " + g.c2.getMissiles());
	     System.out.println("USSR-Moscow Population: " + g.c2.getCityList().get(0).getPopulation());
	     System.out.println("USSR-Moscow Resources: " + g.c2.getCityList().get(0).getResources());
	     System.out.println("");
	     
	     g.roundOver();;
	     
	     System.out.println("");
	     System.out.println("After the Round Missiles get generated");
	     System.out.println("");
	     System.out.println("USA Missiles: " + g.c1.getMissiles());
	     System.out.println("USA-New York Population: " + g.c1.getCityList().get(0).getPopulation());
	     System.out.println("USA-New York Resources: " + g.c1.getCityList().get(0).getResources());
	     System.out.println("");
	     System.out.println("USSR-Moscow Missiles: " + g.c2.getMissiles());
	     System.out.println("USSR-Moscow Population: " + g.c2.getCityList().get(0).getPopulation());
	     System.out.println("USSR Resources: " + g.c2.getCityList().get(0).getResources());
	     System.out.println("");
	     
	     //Loop will run until a winner is decided
	     while(end == false){
		     if(g.c1.playerTurn(1, g.c1.getMissiles() / 2, g.c2.getCityList().get(0))){

		    	 System.out.println("USA Wins");
		    	 end = true;
		    	 break;
		    	 
		     }
		     if(g.c2.playerTurn(2, g.c2.getMissiles() / 2, g.c1.getCityList().get(0))){
		    	 
			     System.out.println("USSR Wins");
			     end = true;
			     break;
			     
		     }
		     
		     g.roundOver();
		     
	     }
	     
	     g.endGame();
	     
	     System.out.println("");
	     System.out.println("End of Game:");
	     System.out.println("");
	     System.out.println("USA Missiles: " + g.c1.getMissiles());
	     System.out.println("USA-New York Population: " + g.c1.getCityList().get(0).getPopulation());
	     System.out.println("USA-New York Resources: " + g.c1.getCityList().get(0).getResources());
	     System.out.println("USA Population Lost: " + g.c1.getStats().getPopulationLost());
	     System.out.println("USA Resources Lost: " + g.c1.getStats().getResourcesLost());
	     System.out.println("");
	     System.out.println("USSR-Moscow Missiles: " + g.c2.getMissiles());
	     System.out.println("USSR-Moscow Population: " + g.c2.getCityList().get(0).getPopulation());
	     System.out.println("USSR-Moscow Resources: " + g.c2.getCityList().get(0).getResources());
	     System.out.println("USSR-Moscow Population Lost: " + g.c2.getStats().getPopulationLost());
	     System.out.println("USR-Moscow Resources Lost: " + g.c2.getStats().getResourcesLost());
	     System.out.println("");
	     System.out.println(g.c1.getPlayer().getName()+" High Score: " + g.c1.getPlayer().getHighScore());
	     System.out.println(g.c2.getPlayer().getName()+" High Score: " + g.c2.getPlayer().getHighScore());
	     System.out.println("");
	     System.out.println("");
	     System.out.println("||||||||||High Score Board||||||||||");
	     
	     
	     for (int i = 0; i < g.highScore.getTop5().size(); i++){
	    	 System.out.println(g.highScore.getTop5().get(i).getName() + "    " + g.highScore.getTop5().get(i).getHighScore());
	     }
	     
	     Game.saveData(g);
	     
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

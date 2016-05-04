package org.project.gamescreen;

import java.io.Serializable;
import java.util.*;

public class Country implements Serializable{
	
	private String name;
	private ArrayList<City> cityList;
	private int resources;
	private int population;
	private int missiles;
	private Random rand;
	private Player player;
	private Statistics stats;
	
	//constructor
	public Country(){
		
		name = "unknown";
		cityList = new ArrayList<City>();
		resources = 400;
		population = 600;
		missiles = 100;
		rand = new Random();
		player = new Player();
		stats = new Statistics();
		
	}

	//Getters and Setters
	
	
	
	public String getName() {
		return name;
	}

	public Statistics getStats() {
		return stats;
	}

	public void setStats(Statistics stats) {
		this.stats = stats;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getMissiles() {
		return missiles;
	}

	public void setMissiles(int missiles) {
		this.missiles = missiles;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<City> getCityList() {
		return cityList;
	}

	public void setCityList(ArrayList<City> cityList) {
		this.cityList = cityList;
	}
	
	public int getResources() {
		return resources;
	}

	public void setResources(int resources) {
		this.resources = resources;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	//Other functions
	public void addCity(City newCity){
		
		this.cityList.add(newCity);
		newCity.setCountry(this);
		
	}
	
	public void removeCity(City toRemove){
		
		this.cityList.remove(toRemove);
		
	}
	
	public void sendNuke(Country enemy){
		
	}
	
	public void receiveNuke(Country enemy){
		
	}
	
	//attack choice: (1-Resource) (2-Population) (3-Both)
	public boolean playerTurn(int attackChoice, int missileUsage, City target){
		boolean destroyed = false;
		
		destroyed = target.attacked(attackChoice, missileUsage);
		this.missiles = this.missiles - missileUsage;
		
		
		
		return destroyed;
	}
	
	public void reset(){
		
		missiles = 100;
		stats = new Statistics();
		for(int i = 0; i < this.cityList.size(); i++){
			this.cityList.get(i).reset();
		}
		
		
	}


}

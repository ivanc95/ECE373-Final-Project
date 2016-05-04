package org.project.gamescreen;

import java.io.Serializable;
import java.util.Random;

public class City implements Serializable{
	
	private String name;
	private int populationC;
	private int populationI;
	private int population;
	private int resources;
	private int missiles;
	private boolean destroyed;
	private Country country;
	private Random rand;

	//Constructor that initializes city and adds it to a country
	public City(Country country){
		name = "unkown";
		populationC = -1;
		populationI = -1;
		missiles = -1;
		destroyed = false;
		this.country = country;
		rand = new Random();
		population = 800 - rand.nextInt(200);
		resources = 600 - rand.nextInt(200);
	}

	//Getters and Setters
	
	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulationC() {
		return populationC;
	}

	public void setPopulationC(int populationC) {
		this.populationC = populationC;
	}

	public int getPopulationI() {
		return populationI;
	}

	public void setPopulationI(int populationI) {
		this.populationI = populationI;
	}

	public int getResources() {
		return resources;
	}

	public void setResources(int resources) {
		this.resources = resources;
	}

	public int getMissiles() {
		return missiles;
	}

	public void setMissiles(int missiles) {
		this.missiles = missiles;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	//Other functions
	public void destroy(){
		
		this.destroyed = true;
		this.country.getCityList().remove(this);
		
	}
	
public boolean attacked(int attackChoice, int missileUsage){
		
		this.destroyed = false;
		int x;
		double percent;
		
		if(missileUsage > 100){
			x = rand.nextInt(20);
		}
		else if(missileUsage > 50){
			x = rand.nextInt(30);
		}
		else if(missileUsage > 0){
			x = rand.nextInt(40);
		}
		else{
			x = 100;
		}
		
		x = 100 - x;
		percent = (double)x / 100;
		
		if(attackChoice == 1){
			this.setResources(this.getResources() - (int)(80 * percent));
			country.getStats().setResourcesLost(country.getStats().getResourcesLost() + (int)(80 * percent));
		}
		
		else if(attackChoice == 2){
			this.setPopulation(this.getPopulation() - (int)(120 * percent));
			country.getStats().setPopulationLost(country.getStats().getPopulationLost() + (int)(120 * percent));
		}
		else if(attackChoice == 3){
			this.setResources(this.getResources() - (int)(80 * percent * 0.5));
			this.setPopulation(this.getPopulation() - (int)(120 * percent * 0.5));
			country.getStats().setResourcesLost(country.getStats().getResourcesLost() + (int)(80 * percent * 0.5));
			country.getStats().setPopulationLost(country.getStats().getPopulationLost() + (int)(120 * percent * 0.5));
		}
		
		
		if((this.population <= 0) || (this.resources <= 0)){
			this.destroyed = true;
		}
		
		return this.destroyed;
		
	}

public void missileGeneration(){
	int x,y;
	double percentP;
	double percentR;
	
	//missile generation
	if(this.getPopulation() > 800){
		x = rand.nextInt(20);
	}
	else if(this.getPopulation() > 600){
		x = rand.nextInt(30);
	}
	else{
		x = rand.nextInt(40);
	}
	
	if(this.getResources() > 600){
		y = rand.nextInt(20);

	}
	else if(this.getResources() > 400){
		y = rand.nextInt(30);
	}
	else{
		y = rand.nextInt(40);
	}
	
	x = 100 - x;
	percentP = (double)x/100;
	percentP = 0.4 * percentP;
	
	y = 100 - y;
	percentR = (double)y/100;
	percentR = 0.6 * percentR;
	
	this.country.setMissiles(country.getMissiles() + (int)(10 * (percentP + percentR)));
	
	}

	public void reset(){
		

		population = 800 - rand.nextInt(200);
		resources = 600 - rand.nextInt(200);
		missiles = 100;
		destroyed = false;
		
	}
	
}

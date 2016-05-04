package org.project.gamescreen;

import java.io.Serializable;

public class Statistics implements Serializable{
	
	private int populationLost;
	private int resourcesLost;
	private int turns;
	
	public Statistics(){
		
		populationLost = 0;
		resourcesLost = 0;
		turns = 0;
		
	}
	
	
	//Getters and Setters
	
	
	public int getTurns() {
		return turns;
	}
	public int getPopulationLost() {
		return populationLost;
	}
	public void setPopulationLost(int populationLost) {
		this.populationLost = populationLost;
	}
	public int getResourcesLost() {
		return resourcesLost;
	}
	public void setResourcesLost(int resourcesLost) {
		this.resourcesLost = resourcesLost;
	}
	public void setTurns(int turns) {
		this.turns = turns;
	}
	

}

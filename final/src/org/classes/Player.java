package org.classes;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

import org.project.gamescreen.Country;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8416138786973735472L;
	private String name;
	private int highscore;
	private ImageIcon pic;
	private Country mine;
	
	public Player() {
		name = null;
		highscore = 0;
		pic = null;
	}
	
	public Player(String n, ImageIcon p) {
		name = n;
		highscore = 0;
		pic = p;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}
	
	public int getHighScore() {
		return highscore;
	}
	public boolean setHighScore(int score) {
		boolean output = false;
		if (highscore < score) {
			highscore = score;
			output = true;
		}
		return output;
	}
	
	public ImageIcon getPicture_path() {
		return pic;
	}
	public void setPicture_path(ImageIcon P) {
		pic = P;
	}

	public void setCountry(Country c1) {
		mine = c1;
		
	}
	
	public void getScore(Country enemy) {
		int score = 0;
		score = score + enemy.getStats().getPopulationLost();
		score = score + (int)(enemy.getStats().getResourcesLost() * 1.5);
		score = score - this.mine.getStats().getTurns();
		
		if( this.highscore < score) {
			this.highscore = score;
		}
	}	
}

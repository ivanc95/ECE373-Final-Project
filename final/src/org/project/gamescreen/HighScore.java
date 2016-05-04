package org.project.gamescreen;

import org.classes.*;
import java.io.Serializable;
import java.util.*;

public class HighScore implements Serializable{
	
	private ArrayList<Player> top5;
	
	public HighScore(){
		top5 = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player){
		

		
		if (!this.top5.contains(player)) {
			if (this.top5.size() < 5) {

				this.top5.add(player);
				this.sortScores();
				return;

			}

			else {
				for (int i = 0; i < top5.size(); i++) {

					if ((player.getHighScore() > this.top5.get(i).getHighScore())) {

						this.top5.remove(i);
						this.top5.add(player);
						this.sortScores();

					}

				}
			} 
		}
		
	}
	
	
	
	public ArrayList<Player> getTop5() {
		return top5;
	}



	public void setTop5(ArrayList<Player> top5) {
		this.top5 = top5;
	}



	public void sortScores(){
		
		Collections.sort(this.top5, new CustomComparator());
		
	}
	
	public class CustomComparator implements Comparator<Player>{
		@Override
		public int compare(Player p1, Player p2){
			return p1.getHighScore() - p2.getHighScore();
		}
		
	}
	
	

}

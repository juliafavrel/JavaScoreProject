package scores;

import java.util.Comparator;

public class BestPlayer implements Comparable<BestPlayer>{
	String player;
	int score;
	
	public BestPlayer(String nom,int score){
		this.player = nom;
		this.score = score;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public String getName(){
		return this.player;
	}
	
	public int compareTo(BestPlayer p){
		if (this.getScore()==p.getScore())
			return 0;
		else if (this.getScore()>p.getScore())
				return 1;
			else 
				return -1;
	}
}
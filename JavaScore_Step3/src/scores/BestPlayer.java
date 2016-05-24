package scores;

import java.util.*;
import java.io.*;
import java.net.*;

public class BestPlayer implements Comparable<BestPlayer>{
	String player;
	int score;
	
	/**
	*	Constructeur de BestJoueur
	*	@param nom Nom du joueur
	*	@param score Score du joueur
	*/
	public BestPlayer(String nom,int score){
		this.player = nom;
		this.score = score;
	}
	
	/**
	*	Score du joueur
	*	@return this.score Score du joueur
	*/
	public int getScore(){
		return this.score;
	}
	
	/**
	*	Nom du joueur
	*	@return this.player Nom du joueur
	*/
	public String getName(){
		return this.player;
	}
	
	/**
	*	Compare deux joueurs
	*	@param p BestPlayer joueur avec lequel comparer
	*	@return int 0 si scores égaux, 1 si p a un score inférieur au nôtre et -1 si p a un score supérieur
	*/
	public int compareTo(BestPlayer p){
		if (this.getScore()==p.getScore())
			return 0;
		else if (this.getScore()>p.getScore())
				return 1;
			else 
				return -1;
	}
}
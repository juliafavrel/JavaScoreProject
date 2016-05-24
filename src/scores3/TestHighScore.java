package scores3;
	

import java.util.*;
import java.io.*;
import java.net.*;


public class TestHighScore {
	

/**
*	Demande le nom du joueur, récupère les scores du fichier .txt et affecte au joueur un score aléatoire parmi ceux récupérés, affiche les scores en ligne ainsi que le 
*	@param args Non utilisés
*/
public static void main(String [] args){
			//Demande le nom du joueur
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez entrer le nom du joueur : ");
			String name = sc.nextLine();
			sc.close();
			
			//Récupère les scores de scoreSamples.txt
			ArrayList<Integer> tableauscore = new ArrayList<Integer>();
			int index = 0;
			String file = "../scoreSamples.txt";
			BufferedReader br = null;
			try{
				br = new BufferedReader(new FileReader(file));
				while (index<10){
					int prochainentier = Integer.parseInt(br.readLine());
					tableauscore.add(index,prochainentier);
					index++;
				}
				br.close();
			} 
			catch (IOException e) {
				System.out.println("erreur io");
				e.printStackTrace();
			}
			catch (NumberFormatException e) {
				System.out.println("erreur number");
				e.printStackTrace();
			}
			
			//Choisi un index aléatoire  
			int i = (int)(Math.random() * index);

			//Affiche le nom du joueur et son score choisi aléatoirement
			int score = tableauscore.get(i);
			System.out.println("Nom Joueur : "+ name + " score : " +  score);
			
			//Affiche tous les scores qui sont en ligne
			System.out.println("Les scores en lignes sont : ");
			String[] scores = HighScore.getScores();
			for (i = 0 ; i< scores.length ; i++)
					System.out.println(scores[i]);
			

			//Affiche les 10 meilleurs joueurs
			BestPlayer[] top10 = HighScore.tenBestScores(scores);
			for(i=0;i<10;i++){
				System.out.println(top10[i].getName() + " : " + top10[i].getScore());
			}

			//Si le joueur a un score suffisant, l'ajoute dans le top 10
			for (BestPlayer p : top10)
        	{
            		if (p.getScore() < score)
            		{
                		HighScore.sendScore(new BestPlayer(name,score));
                		break;
            		}
        	}
			
	}
}
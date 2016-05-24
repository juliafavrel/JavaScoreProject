package scores;
	

import java.util.*;
import java.io.*;

public class TestHighScore {
	

/**
*	Demande le nom du joueur et le retourne
*	@return name Le nom du joueur
*/
public static void main(String [] arg){
			//Partie 1
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez entrer le nom du joueur : ");
			String name = sc.nextLine();
			sc.close();
			
			ArrayList<Integer> tableauscore = new ArrayList<Integer>();
			int index = 0;
			String file = "scoreSamples.txt";
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
			
			int i = (int)(Math.random() * index);

			System.out.println("Nom Joueur "+ name + " score " +  tableauscore.get(i));
			
			System.out.println("Les scores en lignes sont : ");
			String[] scores = HighScore.getScores();
			for (i = 0 ; i< scores.length ; i++)
					System.out.println(scores[i]);
			
			//Partie 2
			BestPlayer[] top10 = HighScore.tenBestScores(scores);
			for(i=0;i<10;i++){
				System.out.println(top10[i].getName() + " : " + top10[i].getScore());
			}
			
	}
}
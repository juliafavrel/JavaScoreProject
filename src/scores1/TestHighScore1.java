package scores1;
	

import java.util.*;
import java.io.*;

public class TestHighScore1 {
	

/**
*	Demande le nom du joueur et le retourne
*	@return name Le nom du joueur
*/
private String askName(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom du joueur : ");
		String name = sc.nextLine();
		System.out.println("Votre joueur s'appelle : " + name);
		sc.close();
		return name;
	}


/**
*	Recupère les scores de scoreSample.txt et les retourne
*	@return tableauscore Le tableau dynamique contenant les scores de scoreSample.txt
*/
private static ArrayList<Integer> chooseScore(){
	ArrayList<Integer> tableauscore = new ArrayList<Integer>();
	int index = 0;
	String file = "../scoreSamples.txt";
	BufferedReader br = null;
	try{
		br = new BufferedReader(new FileReader(file));
		while (br.readLine()!=null){
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
	return tableauscore;
}

/**
*	Demande le nom du joueur, récupère les scores du fichier .txt et affecte au joueur un score aléatoire parmi ceux récupérés
*	@param args Non utilisés
*/
public static void main(String [] args){
			TestHighScore1 test1 = new TestHighScore1();
			String name = test1.askName();
			ArrayList<Integer> tableauScore = new ArrayList<Integer>();
			tableauScore = chooseScore();
			int taille = tableauScore.size();
			int index = (int)(Math.random() * taille);
			System.out.println("Nom Joueur "+ name + " score " +  tableauScore.get(index));
		}
}

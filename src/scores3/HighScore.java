package scores3;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighScore {
	
	/**
	*	Récupère les scores en ligne sur ThingSpeak
	*	@return tabScorefini Tableau avec tous les scores en ligne
	*/
	public static String[] getScores(){
		int index=0;
		String[] tabScore = new String[100];
		BufferedReader in = null;
		try {

			URL url = new URL("https://api.thingspeak.com/channels/109390/feeds.csv");
			URLConnection connexion = url.openConnection();
			in = new BufferedReader(new InputStreamReader(connexion.getInputStream()));
			
			String nextLine = in.readLine();
			while ((nextLine = in.readLine()) != null && nextLine.length()>=1){
				System.out.println(nextLine);
				tabScore[index]=nextLine;
				index++;
			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("erreur fichier non trouvé");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("erreur IO");
			e.printStackTrace();
		}
		String[] tabScorefini = new String[index];
		
		for(int i=0;i<index;i++){
			tabScorefini[i] = tabScore[i];
		}
		return tabScorefini;
	}


	/**
	*	Récupère les 10 meilleurs scores et les retourne
	*	@param readScores Scores
	*	@return top10 Tableau des 10 meilleurs joueurs
	*/
	public static BestPlayer[] tenBestScores(String[] readScores){
		List<BestPlayer> allBest = new ArrayList<>();
		int index=0;
		String ligne_actuelle = "";
		
		while (index < readScores.length){
			String ligne[] = readScores[index].split(",");
			
			BestPlayer joueur_actuel = new BestPlayer(ligne[3],Integer.parseInt(ligne[2]));
			allBest.add(joueur_actuel);
			index++;
		}
		
		Collections.sort(allBest,Collections.reverseOrder());
		
		BestPlayer[] top10 = new BestPlayer[10];
		for(index=0;index<10;index++){
			top10[index] = allBest.get(index);
		}
		return top10;
	}

	/**
	*	Modifie les données de ThingSpeack avec les données du joueur et son score
	*	@param p Joueur pour lequel on veut envoyer les données à ThingSpeak
	*/
    public static void sendScore(BestPlayer p){
        	try {
            	String nom = p.getName();
            	int score = p.getScore();
            	URL getURL = new URL("https://api.thingspeak.com/update?api_key=HA29IZ5RO3W2ROL5&field1="+score+ "&field2="+nom);
            	getURL.openStream();
        	} catch (Exception e) { e.printStackTrace(); }
    }

}

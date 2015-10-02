package problemeSacADos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class permettant de caracteriser un objet sac
 */
public class Sac {
	//nombre de parametres d'un sac 
	private final int NB_PARAM_OBJET = 0;
	private final int NB_PARAM_POIDS = 1;
	private final int NB_PARAM_VALEUR = 2;
	//attributs d'un sac
	
	//Objets du sac 
	private ArrayList< Objet> objets;
	
	//constucteur pour creer un sac vide
	public Sac(){
		this.objets = null;
	}
	public Sac(String cheminFichier, int maxPoids){
		this.objets = new ArrayList<Objet>();
		//creation des objet à partir du fichier entrer en parametre
		this.fileToSac(cheminFichier);
	}
	/**
	 * Méthode permetant de recupérer les éléments du fichier texte et les intégrer à l'objet sac
	 * @param cheminFichier chaine de caractere contenant le chemin du fichier
	 */
	private void fileToSac(String cheminFichier){
		File f = new File(cheminFichier);
		try {
			Scanner sc = new Scanner(f);
			//Variables temporaire pour recuperer le nom de l'objet
			String[] tmp ;			
			//Lecture du fichier (chaque valeur est separée par un ;)
			while(sc.hasNextLine()){
				//recuperation de la ligne 
				tmp = sc.nextLine().split(";");
				//creation d'un Objet et ajout à la liste
				this.objets.add(new Objet(tmp[NB_PARAM_OBJET],Float.parseFloat(tmp[NB_PARAM_POIDS]),Float.parseFloat( tmp[NB_PARAM_VALEUR])));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier d'entrer introuvable");
		}
	}
	
	public ArrayList<Objet> getObjets(){
		return this.objets;
	}
	
	/**
	 * Affichage du contenu du sac
	 */
	public String toString(){
		String contenu ="";
		contenu += "Objet | Poids | Valeur " + "\n\n";
		for(Objet o : this.objets)
			contenu += o.toString() + "\n";
		return contenu;
	}
}

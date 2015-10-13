package problemeSacADos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class permettant de caracteriser un objet contenu
 */
public class Contenu {
	//nombre de parametres d'un contenu 
	private final int NB_PARAM_OBJET = 0;
	private final int NB_PARAM_POIDS = 1;
	private final int NB_PARAM_VALEUR = 2;
	//attributs d'un contenu
	
	//Objets du contenu 
	private ArrayList< Objet> objets;
	
	//constucteur pour creer un contenu vide
	public Contenu(){
		this.objets = null;
	}
	public Contenu(String cheminFichier, int maxPoids){
		this.objets = new ArrayList<Objet>();
		//creation des objet à partir du fichier entrer en parametre
		this.fileTocontenu(cheminFichier);
	}
	/**
	 * Méthode permetant de recupérer les éléments du fichier texte et les intégrer à l'objet contenu
	 * @param cheminFichier chaine de caractere contenant le chemin du fichier
	 */
	private void fileTocontenu(String cheminFichier){
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
	 * Affichage du contenu du contenu
	 */
	public String toString(){
		String contenu ="";
		contenu += "Objet | Poids | Valeur " + "\n\n";
		for(Objet o : this.objets)
			contenu += o.toString() + "\n";
		return contenu;
	}
	/**
	 * methode retounant la somme des valeurs des objets
	 */
	public float getSommeValeurObjet(){
		float somme = 0;
		for(Objet o :this.objets )
			somme+=o.getValeur();
		return somme;
	}
	
}

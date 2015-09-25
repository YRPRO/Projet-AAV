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
	private ArrayList<String> objets;
	//Poids de chacun des objets
	private ArrayList<Integer> poids;
	//valeur de chacun des objets
	private ArrayList<Integer> valeurs;
	//Poids maximum
	private Integer maxPoid;
	//constucteur pour creer un sac vide
	public Sac(){
		this.objets = null;
		this.poids = null;
		this.valeurs = null;
		this.maxPoid = null;
	}
	public Sac(String cheminFichier, int maxPoids){
		this.maxPoid = maxPoids;
		this.objets = new ArrayList<String>();
		this.poids = new ArrayList<Integer>();
		this.valeurs = new ArrayList<Integer>();
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
				//decoupage la ligne -> recuperation du nom de l'objet
				this.objets.add(tmp[NB_PARAM_OBJET]);
				//decoupage la ligne -> recuperation du poids de l'objet
				this.poids.add(Integer.parseInt(tmp[NB_PARAM_POIDS]));
				//decoupage la ligne -> recuperation de la valeur de l'objet
				this.valeurs.add(Integer.parseInt(tmp[NB_PARAM_VALEUR]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichier d'entrer introuvable");
		}
	}
	
	public ArrayList<String> getTabObjet(){
		return this.objets;
	}
	
	public ArrayList<Integer> getTabPoids(){
		return this.poids;
	}
	
	public ArrayList<Integer> getTAbValeur(){
		return this.valeurs;
	}
	
	public int getMaxPoids(){
		return this.maxPoid;
	}
	/**
	 * Affichage du contenu du sac
	 */
	public String toString(){
		String contenu ="";
		contenu += "Objet | Poids | Valeur " + "\n\n";
		for(int i = 0;i<this.objets.size();i++){
			contenu += this.objets.get(i) + "|" + this.poids.get(i) + "|" + this.valeurs.get(i) + "\n";
		}
		return contenu;
	}
}

package problemeSacADos;
/**
 * Class caracterisant un objets qui sera par le suite contenu dans un sac
 */
public class Objet {
	//attributs
	private String nom;
	private float poids;
	private float valeur;
	
	//constucteur
	public Objet(String nom,float poids,float valeur){
		this.nom = nom;
		this.poids = poids;
		this.valeur = valeur;
	}
	
	public String getNom(){
		return this.nom;
	}
	public float getPoids(){
		return this.poids;
	}
	public float getValeur(){
		return this.valeur;
	}
	public String toString(){
		return this.nom + "|" + this.poids + "|" + this.valeur;
	}
}

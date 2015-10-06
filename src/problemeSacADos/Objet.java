package problemeSacADos;
/**
 * Class caracterisant un objets qui sera par le suite contenu dans un sac
 */
public class Objet implements Comparable<Objet>{
	//attributs
	private String nom;
	private Float poids;
	private Float valeur;
	
	//constucteur
	public Objet(){
		this.nom = null;
		this.poids =  null;
		this.valeur =  null;
	}
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
	public float getRaportPoidsValeur(){
		return (this.valeur/this.poids);
	}

	@Override
	public int compareTo(Objet o) {
		if(this.getRaportPoidsValeur() > o.getRaportPoidsValeur())
			return 1;
		if(this.getRaportPoidsValeur() > o.getRaportPoidsValeur())
			return -1;

		return 0;
	}
}

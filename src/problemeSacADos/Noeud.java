package problemeSacADos;

import java.util.ArrayList;

public class Noeud implements Comparable<Noeud> {
	private float valeur;
	private ArrayList<Objet> contenu;
	
	public Noeud(){
		this.valeur = 0;
		this.contenu = null;
	}
	
	public Noeud(ArrayList<Objet> list){
		this.contenu = new ArrayList<Objet>();
		for(Objet o: list)
			this.contenu.add(o);
		
		this.valeur = this.calculerValeur();
	}

	public float getValeur() {
		return valeur;
	}
	public float getPoids(){
		float poids = 0;
		for(Objet o :this.contenu)
			poids+=o.getPoids();
		return poids;
	}
	public ArrayList<Objet> getContenu(){
		return this.contenu;
	}
	private float calculerValeur(){
		float val =0;
		for(Objet o :this.contenu)
			val+=o.getValeur();
		return val;
	}
	public String toString(){
		return this.contenu.toString();
	}

	@Override
	public int compareTo(Noeud o) {
		if(this.valeur > o.valeur)
			return 1;
		if(this.valeur < o.valeur)
			return -1;
		
		return 0;
	}
}

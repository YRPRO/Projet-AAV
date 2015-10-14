package problemeSacADos;

import java.util.ArrayList;

public class ABR {
	private ArrayList<Objet> valeur ; 
	private ABR sousArbreGauche ; 
	private ABR sousArbreDroit ; 
	
	public ABR (){
		this.valeur = new ArrayList<Objet>() ;
		this.sousArbreGauche = null ;
		this.sousArbreDroit = null ;
	}
	/*public ABR (Double valeur){
		this.valeur = valeur ;
		this.sousArbreGauche = null ;
		this.sousArbreDroit = null ;
	}*/
	private ArrayList<Objet> getValeur (){
		return this.valeur ;
	}
	/*private void setValeur ( double v){
		this.valeur = v;
	}*/
	public void ajouter (Objet o){
		if ( this.valeur.isEmpty() ){
			//this.valeur = new ArrayList<Objet>();
			this.valeur.add(o);
			this.sousArbreGauche = new ABR ();
			this.sousArbreDroit = new ABR ();
		}
		else {
			if ( this.getSommeNoeud() > o.getValeur()){
				sousArbreGauche.ajouter (o);
			} 
			else {
				sousArbreDroit.ajouter(o);
			}
		}
	}
	public void ajouterObjet (Objet o){
		if ( ! this.valeur.contains(o) ){
			//this.valeur = new ArrayList<Objet>();
			this.valeur.add(o);
			this.sousArbreGauche = new ABR ();
			recopieListe(this.valeur, this.sousArbreGauche.valeur);
			this.sousArbreDroit = new ABR ();
		}
		else {
			if ( this.getSommeNoeud() > o.getValeur()){
				sousArbreGauche.ajouter (o);
			} 
			else {
				sousArbreDroit.ajouter(o);
			}
		}
	}
	public void ajouterVide (){
			this.sousArbreDroit = new ABR ();
			recopieListe(this.valeur, this.sousArbreDroit.valeur);
	}
	public void ajouterListe(ArrayList<Objet> l){
		if ( this.valeur.isEmpty() ){
			//this.valeur = new ArrayList<Objet>();
			recopieListe(l,this.valeur);
			this.sousArbreGauche = new ABR ();
			this.sousArbreDroit = new ABR ();
		}
		else {
			if ( this.getSommeNoeud() > getValeurListe(l)){
				sousArbreGauche.ajouterListe (l);
			} 
			else {
				sousArbreDroit.ajouterListe (l);
			}
		}
	}
	private void recopieListe(ArrayList<Objet> l1 ,ArrayList<Objet> l2){
		for(Objet o:l1)
			l2.add(o);
	}
	public String toString (){
		String affichage ;
		if (this.valeur == null ){
			affichage = "";
		}
		else {
			String affichageGauche = "";
			if ( sousArbreGauche != null ){
				affichageGauche = sousArbreGauche . toString ();
			}
			affichage = affichageGauche + this.valeur + "\n";
			String affichageDroit = "";
			if ( sousArbreDroit != null ){
				affichageDroit = sousArbreDroit . toString ();
			}
			affichage += affichageDroit ;
		}
		return affichage ;
	}
	public int hauteur (){
		if ( this . valeur == null ){
			return 0;
		} else {
			int hSAG = sousArbreGauche . hauteur ();
			int hSAD = sousArbreDroit . hauteur ();
			return 1 + (( hSAD > hSAG )? hSAD : hSAG );
		}
	}
	public boolean estEquilibre (){
		if ( this . valeur == null ){
			return true ;
		} else {
			return (( Math . abs( sousArbreGauche . hauteur () - sousArbreDroit . hauteur ()) <= 1)
					&& sousArbreGauche . estEquilibre ()) && sousArbreDroit . estEquilibre ();
		}
	}
	private double getSommeNoeud(){
		if(this.valeur == null)
			return 0;
		else{
			double somme = 0;
			for(Objet o : this.valeur)
				somme+=o.getValeur();
			return somme;
		}
	}
	/**
	 * methode retournant la valeur d'un sac 
	 * @param l liste contenant les objets du sac
	 * @return valeur , somme de la valeur de chacun des objets d'un sac
	 */
	private float getValeurListe(ArrayList<Objet> l){
		float valeur=0;
		for(Objet o : l)
			valeur+= o.getValeur();
		return valeur;
	}
}
package problemeSacADos;

public class ABR {
	private Double valeur ; 
	private ABR sousArbreGauche ; 
	private ABR sousArbreDroit ; 
	
	public ABR (){
		this.valeur = null ;
		this.sousArbreGauche = null ;
		this.sousArbreDroit = null ;
	}
	public ABR (Double valeur){
		this.valeur = valeur ;
		this.sousArbreGauche = null ;
		this.sousArbreDroit = null ;
	}
	private double getValeur (){
		return this.valeur ;
	}
	private void setValeur ( double v){
		this.valeur = v;
	}
	public void ajouter ( double v){
		if ( this.valeur == null ){
			this.valeur = new Double (v);
			this.sousArbreGauche = new ABR ();
			this.sousArbreDroit = new ABR ();
		}
		else {
			if ( this.valeur > v){
				sousArbreGauche.ajouter (v);
			} 
			else {
				sousArbreDroit.ajouter (v);
			}
		}
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
	// De la gauche vers la droite
	public void rotationDroite (){
		double tv = getValeur ();
		setValeur ( sousArbreGauche . getValeur ());
		sousArbreGauche . setValeur (tv );
		ABR ta = this . sousArbreGauche ;
		sousArbreGauche = this . sousArbreGauche . sousArbreGauche ;
		ta. sousArbreGauche = ta. sousArbreDroit ;
		ta. sousArbreDroit = sousArbreDroit ;
		sousArbreDroit = ta;
	}
	// De la droite vers la gauche
	public void rotationGauche (){
		double tv = getValeur ();
		setValeur ( sousArbreDroit . getValeur ());
		sousArbreDroit . setValeur (tv );
		ABR ta = this . sousArbreDroit ;
		sousArbreDroit = this . sousArbreDroit . sousArbreDroit ;
		ta. sousArbreDroit = ta. sousArbreGauche ;
		ta. sousArbreGauche = sousArbreGauche ;
		sousArbreGauche = ta;
	}
	public void ajouterEq ( double v){
		if ( this.valeur == null ){
			this.valeur = new Double (v);
			this.sousArbreGauche = new ABR ();
			this.sousArbreDroit = new ABR ();
		}
		else {
			if ( this.valeur > v){
				sousArbreGauche.ajouterEq (v);
				if (!( estEquilibre ())){
					if (( sousArbreGauche.sousArbreGauche == null )
							|| ( sousArbreGauche.sousArbreGauche.hauteur() < sousArbreGauche.sousArbreDroit.hauteur())){
						sousArbreGauche.rotationDroite();
					}
					rotationGauche();
				}
			} 
			else {
				sousArbreDroit.ajouterEq (v);
				if (!( estEquilibre())){
					if (( sousArbreDroit.sousArbreDroit == null )
							|| ( sousArbreDroit.sousArbreDroit.hauteur() < sousArbreDroit.sousArbreGauche.hauteur())){
						sousArbreDroit . rotationGauche ();
					}
					rotationDroite ();
				}
			}
		}
	}
}
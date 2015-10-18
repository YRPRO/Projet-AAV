package problemeSacADos;

public class ABR {
	/*private Noeud n ; 
	private ABR sousArbreGauche ; 
	private ABR sousArbreDroit ; 
	
	public ABR (){
		this.n =null ;
		this.sousArbreGauche = null ;
		this.sousArbreDroit = null ;
	}
	public ABR (Noeud n){
		this.n = n ;
		this.sousArbreGauche = null ;
		this.sousArbreDroit = null ;
	}
	private Noeud getNoeud(){
		return this.n;
	}
	
	public void ajouter (Noeud n){
		if ( this.n== null){
			this.n= n;
			this.sousArbreGauche = new ABR();
			this.sousArbreDroit = new ABR();
		}
		else {
			if ( n.getSelectionner())
				sousArbreGauche.ajouter (n);
			else 
				sousArbreDroit.ajouter(n);
		}
	}
	
	public String toString (){
		String affichage ;
		if (this.n == null ){
			affichage = "";
		}
		else {
			String affichageGauche = "";
			if ( sousArbreGauche != null ){
				affichageGauche = sousArbreGauche . toString ();
			}
			affichage = affichageGauche + this.n.toString() + "\n";
			String affichageDroit = "";
			if ( sousArbreDroit != null ){
				affichageDroit = sousArbreDroit . toString ();
			}
			affichage += affichageDroit ;
		}
		return affichage ;
	}
	public int hauteur (){
		if ( this.n.getPredecesseur() == null ){
			return 0;
		} else {
			int hSAG = sousArbreGauche . hauteur ();
			int hSAD = sousArbreDroit . hauteur ();
			return 1 + (( hSAD > hSAG )? hSAD : hSAG );
		}
	}*/
}
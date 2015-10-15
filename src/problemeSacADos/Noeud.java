package problemeSacADos;

public class Noeud {
	private Objet o;
	private Noeud predecesseur;
	private float benefice_potentiel;
	
	public Noeud(){
		this.o = null;
		this.predecesseur = null;
		this.benefice_potentiel = 0;
	}
	
	public Noeud(Objet o,Noeud n,float benefice){
		this.o = o;
		this.predecesseur = n;
		this.benefice_potentiel = 0;
	}
	
	public Objet getO() {
		return o;
	}

	public void setO(Objet o) {
		this.o = o;
	}

	public Noeud getPredecesseur() {
		return predecesseur;
	}

	public float getBeneficePotentiel() {
		return benefice_potentiel;
	}

	public void setBeneficePotentiel(float benefice_potentiel) {
		this.benefice_potentiel = benefice_potentiel;
	}
	public String toString(){
		return this.o.toString();
	}
	
	
}

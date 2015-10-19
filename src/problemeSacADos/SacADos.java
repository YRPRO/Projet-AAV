package problemeSacADos;

import java.util.ArrayList;

public class SacADos {
	public final static int MAXPOIDS = 12;
	public static void main(String[] args) {
				Contenu s = new Contenu("fichier_sac.txt",MAXPOIDS);
				System.out.println(s.toString());
				MethodeGloutonne.gloutonne(s, MAXPOIDS);
				ProgDynamique.progDynamique(s, MAXPOIDS);
				PSE.resolutionPSE(s, MAXPOIDS);
	}	
	public static float calculValeurTotal(ArrayList<Objet> l){
		float valeur = 0;
		for(Objet o:l)
			valeur+=o.getValeur();
		return valeur;
	}
	public static float calculPoidsTotal(ArrayList<Objet> l){
		float poids = 0;
		for(Objet o:l)
			poids+=o.getPoids();
		return poids;
	}
}

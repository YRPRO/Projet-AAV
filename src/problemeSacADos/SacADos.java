package problemeSacADos;

import java.util.ArrayList;

public class SacADos {
	public final static int MAXPOIDS = 12;
	public static void main(String[] args) {
				Contenu s = new Contenu("fichier_sac.txt",MAXPOIDS);
				System.out.println(s.toString());
				//System.out.println(ProgDynamique.progDynamique(s, 12));
				PSE.resolutionPSE(s, MAXPOIDS);
	}	
	/**
	 * methode retournant la valeur d'un sac 
	 * @param l liste contenant les objets du sac
	 * @return valeur , somme de la valeur de chacun des objets d'un sac
	 */
	public static float getValeurSac(ArrayList<Objet> l){
		float valeur=0;
		for(Objet o : l)
			valeur+= o.getValeur();
		return valeur;
	}
}

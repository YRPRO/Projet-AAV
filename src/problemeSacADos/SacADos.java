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
	
}

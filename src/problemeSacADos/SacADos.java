package problemeSacADos;

public class SacADos {
	public final static int MAXPOIDS = 12;
	public static void main(String[] args) {
				Sac s = new Sac("fichier_sac.txt",MAXPOIDS);
				System.out.println(s.toString());
				//System.out.println(ProgDynamique.progDynamique(s, 12));
				PSE.resolutionPSE(s, MAXPOIDS);
	}	
}

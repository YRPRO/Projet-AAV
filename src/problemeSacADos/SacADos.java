package problemeSacADos;

import java.util.ArrayList;

public class SacADos {
	
	public static void main(String[] args) {
				/*ArrayList<Character> test = new ArrayList<Character>();
				test = progDynamique(12);
				System.out.println(test.toString());*/
				Sac s = new Sac("fichier_sac.txt",12);
				System.out.println(s.toString());
				System.out.println(progDynamique(s, 12));
	}
	
	/**
	 * Methode de resolution du probleme de sac à dos (test)
	 *@return une liste contenant une combinaison optimal
	 */
	public static ArrayList<String> progDynamique(Sac a_resoudre, int maxPoids){
		//nombre d'objet à traiter
		int nbObjet = a_resoudre.getTabObjet().size();
		int[][] tabTraitement = new int[nbObjet][maxPoids + 1];
		//liste contenant une combinaison optimal
		ArrayList<String> combinaison = new ArrayList<String>();
		
		//debut du traitement remplissage de la premiere ligne
		tabTraitement = initTabTraitement(tabTraitement, a_resoudre);
		//remplissages des lignes suivantes
		tabTraitement = traitementObjet(tabTraitement,a_resoudre);
		
		//recuperation de la combinaison
		combinaison = getCombinaison(tabTraitement, a_resoudre);
		return combinaison;
	}
	/**
	 * Initialisation du tableau de traitement
	 * @param tabIni tableau de traitement
	 * @param a_resoudre sac à traiter
	 * @return le tableau initialisé
	 */
	public static int[][] initTabTraitement(int[][] tabIni,Sac a_resoudre){
		//debut du traitement 
		//remplissage de la premiere ligne
		int j = 0;
		while(j < a_resoudre.getMaxPoids() +1) {
			if (a_resoudre.getTabPoids().get(0) > j)
				tabIni[0][j] = 0;
			else
				tabIni[0][j] = a_resoudre.getTAbValeur().get(0);
			j++;
			}
		return tabIni;
	}
	/**
	 * Traitement des objets
	 * @param tabTraitement le tableau de traitement
	 * @param a_resoudre le sac à resoudre
	 * @return le tableau avec l'ensemble des objets traités
	 */
	public static int[][] traitementObjet(int[][] tabTraitement,Sac a_resoudre){
		for (int i = 1 ; i < a_resoudre.getTabObjet().size(); i++){
			for(int k = 0;k<=a_resoudre.getMaxPoids() ;k++){
				if (a_resoudre.getTabPoids().get(i) > k)
					tabTraitement[i][k] = tabTraitement[i-1][k] ;
				else 
					tabTraitement[i][k] = Math.max(tabTraitement[i-1][k],tabTraitement[i-1][k - a_resoudre.getTabPoids().get(i)] + a_resoudre.getTAbValeur().get(i));
			}
		}
		return tabTraitement;
	}
	/**
	 * Récuperation d'une combinaison optimale pour un tableau traiter
	 * @param tabTraitement le tableau de traitement
	 * @param a_resoudre le sac à resoudre
	 * @return une liste contenant une combinaison optimale
	 */
	public static ArrayList<String> getCombinaison(int[][] tabTraitement,Sac a_resoudre){
		ArrayList<String> combinaison = new ArrayList<String>();
		int x = tabTraitement.length - 1 ;
		int y = tabTraitement[0].length - 1 ;
		while(tabTraitement[x][y] == tabTraitement[x][y - 1]){
			y--;	
		}
		//ajout des lettre representant les objets dans la list
		while( y > 0){
			while(x > 0 && tabTraitement[x][y] == tabTraitement[x-1][y])
				x--;
			y -= a_resoudre.getTabPoids().get(x);
			if (y >= 0){
				combinaison.add(a_resoudre.getTabObjet().get(x));
			}
			x--;
		}	
		return combinaison;
	}
	
	public static String testString(int tab[][]){
		String retour ="";
		for (int i = 0 ; i < tab.length;i++){
				retour+= "\n";
			for (int j = 0;j<tab[0].length;j++){
				retour+= tab[i][j] +" ";
			}
		}
		return retour;	
	}
}

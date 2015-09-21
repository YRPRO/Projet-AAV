package problemeSacADos;

import java.util.ArrayList;

public class SacADos {
	
	public static void main(String[] args) {
		ArrayList<Character> test = new ArrayList<Character>();
				test = progDynamique(12);
				System.out.println(test.toString());
	}
	
	/**
	 * Methode de resolution du probleme de sac à dos (test)
	 *@return une liste contenant une combinaison optimal
	 */
	public static ArrayList<Character> progDynamique(int maxPoids){
		//variables utilisées
		char[] tabObjet = {'A','B','C','D','E','F','G','H'};
		int[] tabValeurs = {5, 8, 14, 6, 13, 17, 10, 4};
		int[] tabPoids = {2, 3,  5, 2,  4,  6,  3, 1};
		int a = tabObjet.length;
		int[][] tabTraitement = new int[a][maxPoids + 1];
		ArrayList<Character> combinaison = new ArrayList<Character>()  ;
		
		//debut du traitement remplissage de la premiere ligne
		tabTraitement = initTabTraitement(tabTraitement,tabPoids,tabValeurs,maxPoids);
		//remplissages des lignes suivantes
		tabTraitement = traitementObjet(tabTraitement, tabPoids, tabValeurs, maxPoids);
		
		//recuperation de la combinaison
		combinaison = getCombinaison(tabTraitement, tabPoids, tabObjet);
		return combinaison;
	}
	/**
	 * initialisation du tableau de traitement de l'algorithme de resolution du sac à dos
	 * @param tabIni
	 * @param tabPoids
	 * @param tabValeurs
	 * @param maxPoids
	 * @return
	 */
	public static int[][] initTabTraitement(int[][] tabIni,int[] tabPoids,int[] tabValeurs,int maxPoids){
		//debut du traitement 
		//remplissage de la premiere ligne
		int j = 0;
		while(j < maxPoids +1) {
			if (tabPoids[0] > j)
				tabIni[0][j] = 0;
			else
				tabIni[0][j] = tabValeurs[0];
			j++;
			}
		return tabIni;
	}
	/**
	 * Traitement des objet (chaque ligne de la matrice correspond à un objet)
	 * @param tabTraitement
	 * @param tabPoids
	 * @param tabValeurs
	 * @param maxPoids
	 * @return
	 */
	public static int[][] traitementObjet(int[][] tabTraitement,int[] tabPoids,int[] tabValeurs ,int maxPoids){
		for (int i = 1 ; i < tabPoids.length; i++){
			for(int k = 0;k<=maxPoids ;k++){
				if (tabPoids[i] > k)
					tabTraitement[i][k] = tabTraitement[i-1][k] ;
				else 
					tabTraitement[i][k] = Math.max(tabTraitement[i-1][k],tabTraitement[i-1][k - tabPoids[i]] + tabValeurs[i]);
			}
		}
		return tabTraitement;
	}
	/**
	 * Recuperation de la combinaison optimale
	 * @param tabTraitement
	 * @param tabPoids
	 * @param tabObjet
	 * @return
	 */
	public static ArrayList<Character> getCombinaison(int[][] tabTraitement,int[] tabPoids,char[] tabObjet){
		ArrayList<Character> combinaison = new ArrayList<Character>();
		int x = tabTraitement.length - 1 ;
		int y = tabTraitement[0].length - 1 ;
		while(tabTraitement[x][y] == tabTraitement[x][y - 1]){
			y--;	
		}
		//ajout des lettre representant les objets dans la list
		while( y > 0){
			while(x > 0 && tabTraitement[x][y] == tabTraitement[x-1][y])
				x--;
			y -= tabPoids[x];
			if (y >= 0){
				combinaison.add(tabObjet[x]);
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

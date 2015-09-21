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
	 * @author YR
	 *@return une liste contenant une combinaison optimal
	 */
	public static ArrayList<Character> progDynamique(int maxPoid){
		//variables utilisées
		char[] tabObjet = {'A','B','C','D','E','F','G','H'};
		int[] tabValeurs = {5, 8, 14, 6, 13, 17, 10, 4};
		int[] tabPoids = {2, 3,  5, 2,  4,  6,  3, 1};
		int a = tabObjet.length;
		int[][] tabTraitement = new int[a][maxPoid + 1];
		ArrayList<Character> combinaison = new ArrayList<Character>()  ;
		
		//debut du traitement 
		//remplissage de la premiere ligne
		int j = 0;
		while(j < maxPoid +1) {
			if (tabPoids[0] > j)
				tabTraitement[0][j] = 0;
			else
				tabTraitement[0][j] = tabValeurs[0];
			j++;
		}
			//reutilisation de j pour l'indice
			j--;
		//remplissages des lignes suivantes
		for (int i = 1 ; i < tabPoids.length; i++){
			for(int k = 0;k<=maxPoid ;k++){
				if (tabPoids[i] > k)
					tabTraitement[i][k] = tabTraitement[i-1][k] ;
				else 
					tabTraitement[i][k] = Math.max(tabTraitement[i-1][k],tabTraitement[i-1][k - tabPoids[i]] + tabValeurs[i]);
					//System.out.println( Math.max(tabTraitement[i-1][j],tabTraitement[i-1][j - tabPoids[i]] + tabValeurs[i]));
			}
		}
		
		
		//recuperation de la combinaison
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
				//System.out.println(tabObjet[x]);
			}
			x--;
		}	
		//System.out.println(testString(tabTraitement));
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

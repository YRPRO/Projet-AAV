package problemeSacADos;

import java.util.ArrayList;

public class SacADos {
	public final static int MAXPOIDS = 12;
	public static void main(String[] args) {
				Sac s = new Sac("fichier_sac.txt",MAXPOIDS);
				System.out.println(s.toString());
				//System.out.println(progDynamique(s, 12));
				//PSE.resolutionPSE(s, MAXPOIDS);
				//TEST
				ArrayList<Objet> test = new ArrayList<Objet>();
				for(Objet o : s.getObjets()){
					test.add(o);
					System.out.println(o.getRaportPoidsValeur());
				}
					
				ComparateurRapportValeurPoids comp = new ComparateurRapportValeurPoids();
				test.sort(comp);
				
	}	
	
	/**
	 * Methode de resolution du probleme de sac � dos (test)
	 *@return une liste contenant une combinaison optimal
	 */
	public static ArrayList<String> progDynamique(Sac a_resoudre, int maxPoids){
		//nombre d'objet � traiter
		int nbObjet = a_resoudre.getObjets().size();
		float[][] tabTraitement = new float[nbObjet][maxPoids + 1];
		//liste contenant une combinaison optimal
		ArrayList<String> combinaison = new ArrayList<String>();
		
		//debut du traitement remplissage de la premiere ligne
		tabTraitement = initTabTraitement(tabTraitement, a_resoudre,maxPoids);
		//remplissages des lignes suivantes
		tabTraitement = traitementObjet(tabTraitement,a_resoudre,maxPoids);
		
		//recuperation de la combinaison
		combinaison = getCombinaison(tabTraitement, a_resoudre);
		return combinaison;
	}
	/**
	 * Initialisation du tableau de traitement
	 * @param tabIni tableau de traitement
	 * @param a_resoudre sac � traiter
	 * @return le tableau initialis�
	 */
	public static float[][] initTabTraitement(float[][] tabIni,Sac a_resoudre,int maxPoids){
		//debut du traitement 
		//remplissage de la premiere ligne
		int j = 0;
		while(j < maxPoids +1) {
			if (a_resoudre.getObjets().get(0).getPoids() > j)
				tabIni[0][j] = 0;
			else
				tabIni[0][j] = a_resoudre.getObjets().get(0).getValeur();
			j++;
			}
		return tabIni;
	}
	/**
	 * Traitement des objets
	 * @param tabTraitement le tableau de traitement
	 * @param a_resoudre le sac � resoudre
	 * @return le tableau avec l'ensemble des objets trait�s
	 */
	public static float[][] traitementObjet(float[][] tabTraitement,Sac a_resoudre,int maxPoids){
		for (int i = 1 ; i < a_resoudre.getObjets().size(); i++){
			for(int k = 0;k<= maxPoids ;k++){
				if (a_resoudre.getObjets().get(i).getPoids() > k)
					tabTraitement[i][k] = tabTraitement[i-1][k] ;
				else 
					tabTraitement[i][k] = Math.max(tabTraitement[i-1][k],tabTraitement[i-1][(int) (k - a_resoudre.getObjets().get(i).getPoids())] + a_resoudre.getObjets().get(i).getValeur());
			}
		}
		return tabTraitement;
	}
	/**
	 * R�cuperation d'une combinaison optimale pour un tableau traiter
	 * @param tabTraitement le tableau de traitement
	 * @param a_resoudre le sac � resoudre
	 * @return une liste contenant une combinaison optimale
	 */
	public static ArrayList<String> getCombinaison(float[][] tabTraitement,Sac a_resoudre){
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
			y -= a_resoudre.getObjets().get(x).getPoids();
			if (y >= 0){
				combinaison.add(a_resoudre.getObjets().get(x).getNom());
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

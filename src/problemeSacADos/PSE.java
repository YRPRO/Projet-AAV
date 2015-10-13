package problemeSacADos;

public class PSE {
	public static void resolutionPSE(Contenu s,int maxPoids){
		/*TreeSet<Integer> a = new TreeSet<Integer>(); 
		a.add(0);
		int poids_actuel = 0;
		for(int i = 0 ; i<= s.getObjets().size();i++){
			if(poids_actuel <= maxPoids){
				a.add((int) (a.last() + s.getObjets().get(i).getValeur()));
				poids_actuel += s.getObjets().get(i).getPoids();
				if(i != 0)
					a.add((int) s.getObjets().get(i - 1).getValeur());
				else
					a.add(0);
			}
		}
		System.out.println(a.toString());
	}
	public static void resolutionPSE2(Sac s,int maxPoids){
		TreeSet<Integer> a = new TreeSet<Integer>();
		for(Objet o : s.getObjets()){
			
		}*/
		
		//création d'un arbre ou sera effectuer le traitement (initialisé à 0)
		ABR arbre = new ABR();
		arbre.ajouter(0);
		float borne_inf = 0;
		float borne_sup = 0;
		float val_actuel = 0;
		float val_precedente = 0;
		//on determine la borne inferieur en utilisant la methode gloutonne
		borne_inf = SacADos.getValeurSac(MethodeGloutonne.gloutonne(s, maxPoids));
		//on determine la borne supérieure
		borne_sup = s.getSommeValeurObjet();
		//on parcours les objets pour ajouter leur valeur dans l'arbre
		for(int i = 0;i<s.getObjets().size();i++){
			val_actuel+=s.getObjets().get(i).getValeur();
			if(i>0)
				//arbre.ajouter(s.getObjets().get(i-1).getValeur());
			else
				
				//arbre.ajouter(0);
			//val_actuel+=s.getObjets().get(i).getValeur();
			//arbre.ajouter(val_actuel);
		}
		System.out.println(arbre.toString());
		
	}
}

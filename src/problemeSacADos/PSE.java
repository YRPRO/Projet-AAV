package problemeSacADos;

public class PSE {
	public static void resolutionPSE(Contenu s,int maxPoids){
		ABR arbre = new ABR();
		Noeud n = null;
		arbre.ajouter(n);
		Noeud n2 = new Noeud(s.getObjets().get(0),n,10);
		System.out.println(arbre.hauteur());
		
	}
}

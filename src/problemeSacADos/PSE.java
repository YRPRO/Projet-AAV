package problemeSacADos;

import java.util.ArrayList;

public class PSE {
	public static void resolutionPSE(Contenu c,int maxPoids) {
		//file utiliser lors du traitement
		
		//Queue<Noeud> file = new Queue<Noeud>();
		//ArrayList<Noeud> file = new ArrayList<Noeud>();
		Noeud solution = new Noeud();
		//initialisation de la file avec une noeud vide
		Noeud racine = new Noeud();
		//ajout du noeud racine dans la file
		//file.add(racine);
		solution=racine;
		int poid_actuel_avec = 0;
		int poid_actuel_sans = 0;
		//creation des liste de combinaison 
		for(Objet o :c.getObjets()){
			ArrayList<Objet> combinaisonAvecObjet  = new ArrayList<Objet>();
			ArrayList<Objet> combinaisonSansObjet  = new ArrayList<Objet>();
			//combinaison en prenant l'objet
			for(Objet a:c.getObjets()){
				//creation de la combinaison avec l'objet
				if(poid_actuel_avec + a.getPoids()<=maxPoids){
					combinaisonAvecObjet.add(a);
					poid_actuel_avec+=a.getPoids();
				}
				//creation de la combinaison sans l'objet
				if(poid_actuel_sans + a.getPoids()<=maxPoids){
					combinaisonSansObjet.add(a);
					poid_actuel_sans+=a.getPoids();
				}
			}
			//creation d'un noeud pour la combinaison
			Noeud combAvec = new Noeud(combinaisonAvecObjet);
			Noeud combSans = new Noeud(combinaisonSansObjet);
			//si la valeur est plus elevé on place le noeud dans la file
			//Noeud actuel = file.get(0);
			//file.remove(0);
			if(combAvec.getValeur() > solution.getValeur())
				solution=combAvec;
				//file.add(combAvec);
			if(combSans.getValeur() > solution.getValeur())
				solution=combSans;
				//file.add(combSans);
			/*else
				file.add(actuel);*/
		}
		
		//Noeud solution = file.get(0);
		System.out.println(solution.toString());
		System.out.println(solution.getValeur());
	}
}

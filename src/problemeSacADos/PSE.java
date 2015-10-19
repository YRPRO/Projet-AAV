package problemeSacADos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class PSE {
	public static void resolutionPSE(Contenu c,int maxPoids) {
			Noeud solution = new Noeud();
			//calcule de la meilleur combinaison non inverser
			Noeud meilleurCombNonInverser = calculMeilleurCombinaison(c, maxPoids);
			//inversement du contenu
			Collections.reverse(c.getObjets());
			Noeud meilleurCombInverser = calculMeilleurCombinaison(c, maxPoids);
			if(meilleurCombNonInverser.getValeur() > meilleurCombInverser.getValeur())
				 solution = meilleurCombNonInverser;
			else
				solution = meilleurCombInverser;
			
			System.out.println("Resultat methode PSE :");
			System.out.println("une combinaison optimale est : ");
			System.out.println(solution.toString());
			System.out.println("Pour un poids total de : " + solution.getPoids());
			System.out.println("Pour une valeur total de : " + solution.getValeur());
	}
	
	private static void combinaisonAvecObjet(Contenu c,ArrayList<Objet> liste,Objet concerner,int maxPoids){
		float poids_actuel = 0;
		//ajout de l'objet
		liste.add(concerner);
		poids_actuel+=concerner.getPoids();
		//combinaison sans depasser le poids max et sans reprendre l'objet une 2eme fois
		for(Objet o : c.getObjets()){
			if(!o.equals(concerner) && poids_actuel + o.getPoids() <= maxPoids){
				liste.add(o);
				poids_actuel+=o.getPoids();
			}
		}
	}
	private static void combinaisonSansObjet(Contenu c,ArrayList<Objet> liste,Objet concerner,int maxPoids){
		float poids_actuel = 0;
		//combinaison sans depasser le poids max et sans prendre l'objet concerné
		for(Objet o : c.getObjets()){
			if(!o.equals(concerner) && poids_actuel + o.getPoids() <= maxPoids){
				liste.add(o);
				poids_actuel+=o.getPoids();
			}
		}
	}
	private static Noeud calculMeilleurCombinaison(Contenu c,int maxPoids){
		//file utiliser lors du traitement
				PriorityQueue<Noeud> file = new PriorityQueue<Noeud>();
				Noeud meilleurCombinaison = new Noeud();
				
				//initialisation de la file avec une noeud vide
				Noeud racine = new Noeud();
				//ajout du noeud racine dans la file
				file.offer(racine);
				
				
				//creation des liste de combinaison 
				for(Objet o :c.getObjets()){
					ArrayList<Objet> combinaisonAvecObjet  = new ArrayList<Objet>();
					ArrayList<Objet> combinaisonSansObjet  = new ArrayList<Objet>();
					//creation des combinaisons
					combinaisonAvecObjet(c,combinaisonAvecObjet,o,maxPoids);
					combinaisonSansObjet(c,combinaisonSansObjet,o,maxPoids);
					
					//creation d'un noeud pour la combinaison
					Noeud combAvec = new Noeud(combinaisonAvecObjet);
					Noeud combSans = new Noeud(combinaisonSansObjet);
					
					//ajout des deux combinaison et on ne garde que la meilleur à chaque fois
					file.offer(combAvec);
					file.offer(combSans);
					if(file.poll().getValeur() > meilleurCombinaison.getValeur())
						meilleurCombinaison = file.poll();
				}	
				return meilleurCombinaison;
	}
}

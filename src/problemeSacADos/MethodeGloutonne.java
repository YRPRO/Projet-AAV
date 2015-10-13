package problemeSacADos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MethodeGloutonne {
	public static ArrayList<Objet> gloutonne(Contenu s,int maxPoids){
		ArrayList<Objet> combinaison = new ArrayList<Objet>();
		//tri des objet du sac selon le rapport valeur/poids
		//comparateur de rapport valeur/poids
		Comparator c = new ComparateurRapportValeurPoids();
		Collections.sort(s.getObjets(),c);
		//poids des objets qui seront introduit dans le sac
		Float poidsContenuActuel = (float) 0.0;

		for(Objet o :s.getObjets()){
			if (poidsContenuActuel + o.getPoids() <= maxPoids){
				combinaison.add(o);
				poidsContenuActuel += o.getPoids();
			}
		}
		return combinaison;
	}
}





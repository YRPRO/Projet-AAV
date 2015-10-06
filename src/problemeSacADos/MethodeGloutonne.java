package problemeSacADos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MethodeGloutonne {
	public static String gloutonne(Sac s,int maxPoids){
		ArrayList<String> combinaison = new ArrayList<String>();
		//tri des objet du sac selon le rapport valeur/poids
		//comparateur de rapport valeur/poids
		Comparator c = new ComparateurRapportValeurPoids();
		Collections.sort(s.getObjets(),c);
		System.out.println(s.toString());
		//poids des objets qui seront introduit dans le sac
		Float poidsContenuActuel = (float) 0.0;

		for(Objet o :s.getObjets()){
			if (poidsContenuActuel + o.getPoids() <= maxPoids){
				combinaison.add(o.getNom());
				poidsContenuActuel += o.getPoids();
			}
		}
		return combinaison.toString();
	}
}





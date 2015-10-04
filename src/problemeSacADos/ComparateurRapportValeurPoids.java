package problemeSacADos;

import java.util.Comparator;

public class ComparateurRapportValeurPoids implements Comparator<Objet> {

	@Override
	public int compare(Objet o1, Objet o2) {
		if(o1.getRaportPoidsValeur() > o2.getRaportPoidsValeur())
			return 1;
		if(o1.getRaportPoidsValeur() < o2.getRaportPoidsValeur())
			return -1;
		
		return 0;
	}
	

}

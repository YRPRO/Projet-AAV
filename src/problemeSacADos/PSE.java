package problemeSacADos;

import java.util.TreeSet;

public class PSE {
	public static void resolutionPSE(Sac s,int maxPoids){
		TreeSet<Integer> a = new TreeSet<Integer>(); 
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
}

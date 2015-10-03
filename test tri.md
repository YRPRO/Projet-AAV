import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;

//import java.util.Random;
//import java.lang.Comparable;

public class Objet {
	private int indiceObj;
	private int valObj;
	private int poidsObj;
	private double rapportObj;

	public Objet(int indiceObj, int valObj, int poidsObj, double d) {
		this.indiceObj = indiceObj;
		this.valObj = valObj;
		this.poidsObj = poidsObj;
		this.rapportObj = d;
	}
	

	public static void main(String[] args) {
		ArrayList listObj = new ArrayList<Objet>();
		listObj.add(new Objet(1, 7, 12, 0.58));
		listObj.add(new Objet(2, 2, 9, 0.22));
		listObj.add(new Objet(3, 11, 15, 0.73));
		listObj.add(new Objet(4, 3, 7, 0.42));
		listObj.add(new Objet(5, 8, 20, 0.4));
		//listObj.add(12);
		//listObj.add(22);
		//listObj.add(10);
		//listObj.add(7);
		
		
		System.out.println("Liste non trié : ");
		for(int i=0; i<listObj.size()-1; i++) {
			System.out.println(listObj.get(i)); //faudrait accéder directement au getRapport mais sa déconne
		}
		
		System.out.println("Avec le tri : ");
		Collections.sort(listObj);
		for(int i=0; i<listObj.size()-1; i++) {
			System.out.println(listObj.get(i));
		}
	}

	
	public double getRapportObj() {
		return rapportObj;
	}

	public void setRapportObj(double rapportObj) {
		this.rapportObj = rapportObj;
	}

	public int getPoidsObj() {
		return poidsObj;
	}

	public void setPoidsObj(int poidsObj) {
		this.poidsObj = poidsObj;
	}

}

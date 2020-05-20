import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.lang.Math;

public class BNG {
	
	//Anzahl aller gezählten Ziffern
	public static int gezaehleteZiffern[] = {0,0,0,0,0,0,0,0,0};
	
	//die Liste aller zufalls Zahlen 
	public static List<Integer> akzeptierteZahlen = new ArrayList<Integer>();

	public static void main(String[] args) {
		//anzahl der zu erstellen zufalls Zahlen
		int anzahl = 1000000;
		
		//in dieser Methode Startet der Prozess
		benno(anzahl);
		
		//anzeigen alle zufallszahlen (gerade: aus)
//		for(int i = 0; i < akzeptierteZahlen.size(); i++) {
//			System.out.println(akzeptierteZahlen.get(i));
//		}
		
		// Ergebnis anzeigen und prozent Ausrechnen
		for(int i = 0; i<gezaehleteZiffern.length;i++) {
			System.out.println("Von " + anzahl + " starteten "+ gezaehleteZiffern[i] +" mit "+ (i+1) +" ("+(100/(float)anzahl)*(float)gezaehleteZiffern[i]+"%)");
		}

	}	
	
	public static void benno(int anzahl) {
		
		//erstellen einer Zufallszahlen
		Random rng = new Random(System.currentTimeMillis());
		
		//So lange die gewünschte anzahl noch nicht erreicht ist
		while(akzeptierteZahlen.size() <= anzahl) {
			
			// neue Zufallszahl
			int rngZahl = rng.nextInt();
			
			//erste ziffer brechnen 
			int ersteZiffer = rngZahl;
			//so lange erste ziffe größer als 10 ist
			while(ersteZiffer >= 10) {
				//erste ziffer 
				ersteZiffer = ersteZiffer / 10;
			}
			
			einsortieren(rngZahl, ersteZiffer, anzahl);
			
		}
	}
	
	public static void einsortieren(int zahl, int ziffer, int anzahl) {
		
		//erste ziffer kleiner gleich 0 wird nicht akzeptiert
		if(ziffer <= 0) return;
		
		//berechnen der wahrscheinlichkeit bezüglich der ersten ziffer
		double wahrscheinlichkeit = Math.log10(ziffer +1) - Math.log10(ziffer);
		
		//brechnen des aktuellen verhällnisses  
		double aktWahr = (double)gezaehleteZiffern[ziffer - 1]/(double)anzahl;
		
		//ist das aktuelle Verhällnis kleiner als die Wahrscheinlichkeit der ziffer?
		if(aktWahr<wahrscheinlichkeit) {
			//ja, dann füge es der liste hinzu und erhöhe zähler um 1
			akzeptierteZahlen.add(zahl);
			gezaehleteZiffern[ziffer - 1]++;
		}
	}		
}
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.lang.Math;

public class BNG {

	// Anzahl aller gezählten Ziffern
	public static int gezaehleteZiffern[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	// die Liste aller ganzen Zufallszahlen der
	public static List<Integer> akzeptierteZahlenInt = new ArrayList<Integer>();

	// die Liste aller double Zufallszahlen der
	public static List<Double> akzeptierteZahlenDouble = new ArrayList<Double>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// Die Methode die Nutzer haben will 1 = strikt, 2 = natürlich
		String auswahl = "";
		// ob die erstellten Zufallszahlen angezeigt werden sollen j = ja, n = nein
		char anzeigen = 'n';
		// anzahl der zu erstellen zufalls Zahlen
		int anzahl = 0;

		// menu
		System.out.println("Willkommen. Wählen Sie ihre Methode aus!");
		System.out.println("1: Strikte benfordsche Verteilung");
		System.out.println("2: Natürliche Verteilung");

		auswahl = sc.nextLine();

		switch (auswahl) {
			case "1":
				// Strikte Verteilung
				System.out.println("Geben Sie bitte die Anzahl gewünschten Zufallszahlen an");
				anzahl = sc.nextInt();
				System.out.println("Möchten Sie ALLE Zufalszahlen aufgelistet sehen? (j/n)");
				anzeigen = sc.next().charAt(0);
				benno(anzahl);

				if (anzeigen == 'j') {
					// anzeigen aller zufallszahlen
					for (int i = 0; i < akzeptierteZahlenInt.size(); i++) {
						System.out.println(akzeptierteZahlenInt.get(i));
					}
				}

				// Ergebnis anzeigen und Prozente Ausrechnen
				for (int i = 0; i < gezaehleteZiffern.length; i++) {
					System.out.println("Von " + anzahl + " starteten " + gezaehleteZiffern[i] + " mit " + (i + 1) + " ("+ (100 / (float) anzahl) * (float) gezaehleteZiffern[i] + "%)");
				}
				break;

			case "2":
				// Natürliche Verteilung
				System.out.println("Geben Sie bitte die Anzahl gewünschten Zufallszahlen an");
				anzahl = sc.nextInt();
				System.out.println("Möchten Sie ALLE Zufalszahlen aufgelistet sehen? (j/n)");
				anzeigen = sc.next().charAt(0);
				benno9000(anzahl);

				if (anzeigen == 'j') {
					// anzeigen alle zufallszahlen (gerade: aus)
					for (int i = 0; i < akzeptierteZahlenDouble.size(); i++) {
						System.out.println(akzeptierteZahlenDouble.get(i));
					}
				}

				// Ergebnis anzeigen und Prozente Ausrechnen
				for (int i = 0; i < gezaehleteZiffern.length; i++) {
					System.out.println("Von " + anzahl + " starteten " + gezaehleteZiffern[i] + " mit " + (i + 1) + " ("+ (100 / (float) anzahl) * (float) gezaehleteZiffern[i] + "%)");
				}

				break;

			default:
				System.out.println("Üngültige eingabe! Programm wird beendet");
				break;
		}
		sc.close();
	}

	public static void benno(int anzahl) {

		// erstellen einer Zufallszahlen
		Random rng = new Random(System.currentTimeMillis());

		// So lange die gewünschte anzahl noch nicht erreicht ist
		while (akzeptierteZahlenInt.size() <= anzahl) {

			// neue Zufallszahl
			int rngZahl = rng.nextInt();

			// erste ziffer brechnen
			int ersteZiffer = rngZahl;
			// so lange erste ziffe größer als 10 ist
			while (ersteZiffer >= 10) {
				// erste ziffer
				ersteZiffer = ersteZiffer / 10;
			}
			einsortieren(rngZahl, ersteZiffer, anzahl);
		}
	}

	public static void einsortieren(int zahl, int ziffer, int anzahl) {

		// erste ziffer kleiner gleich 0 wird nicht akzeptiert
		if (ziffer <= 0)
			return;

		// berechnen der wahrscheinlichkeit bezüglich der ersten ziffer
		double wahrscheinlichkeit = Math.log10(ziffer + 1) - Math.log10(ziffer);

		// brechnen des aktuellen verhällnisses
		double aktWahr = (double) gezaehleteZiffern[ziffer - 1] / (double) anzahl;

		// ist das aktuelle Verhällnis kleiner als die Wahrscheinlichkeit der ziffer?
		if (aktWahr < wahrscheinlichkeit) {
			// ja, dann füge es der liste hinzu und erhöhe zähler um 1
			akzeptierteZahlenInt.add(zahl);
			gezaehleteZiffern[ziffer - 1]++;
		}
	}

	//Natürliche Benforsche Zahl
	public static void benno9000(int anzahl) {

		for (int i = 0; i < anzahl; i++) {
			//Zufallsobjekt und Zahlen
			Random rng = new Random();

			//berechnung der benfordschen zahl
			double erg = rng.nextDouble() / rng.nextDouble();

			//Formatierung auf x.xxx
			while (erg < 1.0) {
				erg = erg * 10.0;
			}
			while (erg > 9.9) {
				erg = erg / 10.0;
			}

			//"ist das ergebnis zwischen 1 und 10"
			if (!(erg < 1.0) && erg < 10.0) {
				//wenn ja: eingleidern
				int ziffer = (int) erg;
				akzeptierteZahlenDouble.add(erg);
				gezaehleteZiffern[ziffer - 1]++;
			} else i--; // wenn nein: Zähler um 1 runterzähen
		}
	}
}
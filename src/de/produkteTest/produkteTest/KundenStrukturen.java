package de.produkteTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;

import java.util.List;

public class KundenStrukturen {

	// Eigenschaften
	Kunde kunde;
	// In dieser Map befinden sich alle Kunden
	static Map<Integer, Kunde> mapAlleKundenMap = new LinkedHashMap<>();
	// Durch diese Map hat man zugriff auf mapAlleKundenMap und auf die
	// KundenSammlungen;
	static Map<Integer, KundenStrukturen> mapAlleKundenStrukturen = new LinkedHashMap<>();
	// Diese Map bildet KundenSammlungen/ Buendelungen;
	Map<Integer, Kunde> mapKundenSammlungMap;
	String kundenSammlungNameString;
	int kundenSammlungNummer;

	public int getKundenSammlungNummer() {
		return kundenSammlungNummer;
	}

	static {
		/*
		 * Hier wird ein Objekt erstellt welches eine Map mit allen existierenden Kunden
		 * enthaelt; Dieses Objekt wird dann zu kundenStrukturSammlung hinzugefuegt
		 * damit man darauf zugreifen kann;
		 */
		KundenStrukturen alleKunden = new KundenStrukturen(0000, "AlleKunden");
		alleKunden.mapKundenSammlungMap = mapAlleKundenMap;

	}

	// Konstruktor
	// Dieser Konstruktor erstaelt eine Kundensammlung
	public KundenStrukturen(int kundenSammlungNummer, String kundenSammlungNameString) {
		this.kundenSammlungNummer = kundenSammlungNummer;
		this.kundenSammlungNameString = kundenSammlungNameString;
		this.mapKundenSammlungMap = new LinkedHashMap<>();
	}

	public static class KundenSammlung extends KundenStrukturen.KundenSammlungFunktionen {
		/*
		 * Eine KundenSammlung ist eine Buendelung ausgewaehlter Kunden; Wie z.B.
		 * Gebauer, Aupperle, usw....;
		 */
		// Dieser Konstrukor bildet eine KundenSammlung
		public KundenSammlung(int kundenSammlungNummer, String kundenSammlungNameString) {
			super(kundenSammlungNummer, kundenSammlungNameString);
			// TODO Auto-generated constructor stub
		}

		Scanner scanner = new Scanner(System.in);
		static String eingabeString = null;
		static boolean testSchleife = false;

		public static KundenSammlungFunktionen erstelleKundenSammlung(Scanner scanner) {
			/*
			 * In dieser Methode kann der User eine Kundensammlung erstellen; Er kann ihr
			 * einen Namen und eine Zugriffsnummer also einen Key geben; Wenn eine neue
			 * KundenSammlung erstellt wird, bekommt das KundenSammlungsObjekt eine map, in
			 * welcher Kunden gespeichert werden;
			 */
			KundenSammlungFunktionen newKundenSammlung = null;
			do {
				System.out.println(
						"Hier kannst du eine Sammlung bzw. Buendelung an Kunden erstellen\n[0]Abbruch\n[1]Weiter");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, false,
						false, false);
			} while (testSchleife);

			if (!eingabeString.equals("0")) {
				newKundenSammlung = new KundenSammlung(setKundenSammlungNummer(scanner, testSchleife, eingabeString),
						setKundenSammlungName(scanner, testSchleife, eingabeString));
				KundenStrukturen.mapAlleKundenStrukturen.put(newKundenSammlung.kundenSammlungNummer, newKundenSammlung);
			}

			return newKundenSammlung;
		}

		public static int setKundenSammlungNummer(Scanner scanner, boolean testSchleife, String eingabeString) {
			/*
			 * Diese Methode gibt dem User die moeglichkeit der erstellten KundenSammlung
			 * eine ZugriffsNummer bzw. einen Key zu geben;
			 */
			do {
				System.out.println("Nummer Kundensammlung:___");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, false, false, false,
						true, false);
			} while (testSchleife == true);

			return Integer.parseInt(eingabeString);
		}

		public static String setKundenSammlungName(Scanner scanner, boolean testSchleife, String eingabeString) {
			/*
			 * In dieser Methode hat der User die moeglichkeit der neu erstellten
			 * KundenStruktur einen Namen zu geben, z.B. Gebauer oder Aupperle etc.
			 */
			do {
				testSchleife = false;
				System.out.println("Name Kundensammlung:___");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchString(eingabeString, false, true, false);
			} while (testSchleife == true);

			return eingabeString;
		}

	}

	public static class KundenSammlungFunktionen extends KundenStrukturen {

		public KundenSammlungFunktionen(int kundenSammlungNummer, String kundenSammlungNameString) {
			super(kundenSammlungNummer, kundenSammlungNameString);
			// TODO Auto-generated constructor stub
		}

		boolean testSchleife = false;
		String eingabeString = null;
		Scanner scanner = new Scanner(System.in);

		public static void ausgabeAlleKundenSammlungen() {
			/*
			 * Diese Methode dient der Ausgabe von mapAlleKundenStrukturen; In diesr Map
			 * werden alle KundenSammlungen ausgegeben;
			 */
			for (Integer key : KundenStrukturen.mapAlleKundenStrukturen.keySet()) {
				System.out.println("Nummer: " + key + " " + "Name: "
						+ KundenStrukturen.mapAlleKundenStrukturen.get(key).kundenSammlungNameString);
			}
		}

		public static KundenStrukturen ausgabeBeliebigeKundenSammlung(Scanner scanner, boolean testSchleife,
				String eingabeString) {
			/*
			 * Diese Methode laesst den User eine KundenSammlung auswaehlen welche
			 * anschliesend, mit den beinhaltenen KundenNummern und dazugehoerenden
			 * KundenNamen, ausgegeben wird;
			 */

			/*
			 * Erst kommt eine UserAbfrage welche in einer TryCatchInteger Methode geprueft
			 * wird; Wenn keine Fehlermeldung gethrowt wird, wird das Element hinter dem
			 * hinter dem Key in einer forEachSchleife ausgegeben;
			 */
			System.out.println("Ausgabe einer Beliebigen Kundensammlung");
			do {
				System.out.println("[0]Abbruch\nKundensammlungsnummer:___");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, false,
						false, true);
			} while (testSchleife == true);

			KundenStrukturen kundenSammlungObjekt = null;
			if (!eingabeString.equals("0")) {
				kundenSammlungObjekt = mapAlleKundenStrukturen.get(Integer.parseInt(eingabeString));

				for (Integer key : kundenSammlungObjekt.mapKundenSammlungMap.keySet()) {
					System.out.println("Kundennummer: " + key + " Kundenname: "
							+ kundenSammlungObjekt.mapKundenSammlungMap.get(key).getKundenNameString());
				}
			}
			return kundenSammlungObjekt;
		}

		public static void deleteBeliebigeKundenSammlung(Scanner scanner, boolean testSchleife, String eingabeString) {
			/*
			 * Diese Methode loescht beliebige KundenSammlungen; Der User wird nach der
			 * KundenSammlungsNummer der zu loeschenden KundenSammlung gefragt; Wenn diese
			 * Existiert, wird sie durch einen Iterator geloescht;
			 */

			int eingabeStringZuInt = 0;
			do {
				System.out.println("Um eine Kundensammlung zu loeschen, bitte die zugehoerende Nummer eingeben");
				System.out.println("Kundensammlungsnummer:___" + "\n[0]Abbrechen");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, false,
						false, true);
				eingabeStringZuInt = Integer.parseInt(eingabeString);
			} while (testSchleife == true);

			/*
			 * Als erstes wird ein Iterator erstellt welcher alle Eintraege aus
			 * mapAlleKundenStrukturen speichert; Danach wird in dem dem Itarator das
			 * KundenSammlungObjekt mit dem passenden Key gesucht; Wenn es gefunden wurde,
			 * wird das KundenSammlungObjekt aus mapAlleKundenStrukturen entfernt;
			 */
			iteratorForDeleteBeliebigeKundenSammlung(eingabeStringZuInt);

		}

		public static void iteratorForDeleteBeliebigeKundenSammlung(int eingabeStringZuInt) {
			/*
			 * Hier wird ein Iterator erstellt; Er wird yum loeschen von KundenSammlungen
			 * genutzt;
			 */
			Iterator<Entry<Integer, KundenStrukturen>> iterator = mapAlleKundenStrukturen.entrySet().iterator();
			while (iterator.hasNext()) {
				int kundenSammlungsNummer = iterator.next().getKey();
				if (kundenSammlungsNummer == eingabeStringZuInt) {
					iterator.remove();
				}
			}
		}

		public static void editBeliebigeKundenSammlung(Scanner scanner, boolean testSchleife, String eingabeString) {
			/*
			 * Diese Methode bearbeitet bestehende KundenSammlungen; Als erstes werden alle
			 * KundenSammlungen mit ihren KundenSammlungsNummern ausgegeben; Danach kann der
			 * User per Eingabe eine KundenSammlung wahlen die ers Bearbeiten will;
			 */
			ausgabeAlleKundenSammlungen();
			System.out.println("Welche Kundensammlung willst du bearbeiten?");
			do {
				System.out.println("Kundensammlungsnummer:___\n[0]Abbruch");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, false,
						false, true);
			} while (testSchleife == true);

			if (!eingabeString.equals("0")) {
				/*
				 * Erst wird eime lokale Kopie des Objekt gemacht => changingKundenSammlung;
				 * Danach wird es aus der mapAlleKundenStrukturen geloescht, somit kann es
				 * ersetzt werden; Dann kommen die setter fuer kundenSammlungNummer und
				 * kundenSammlungNameString welche die Werte in changingKundenSammlung
				 * aktualiesieren; Die "Neue" KundenSammlung wird anschliesend wieder zu
				 * mapAlleKundenStrukturen hinzugefuegt;
				 */
				KundenStrukturen changingKundenSammlung = mapAlleKundenStrukturen.get(Integer.parseInt(eingabeString));
				iteratorForDeleteBeliebigeKundenSammlung(changingKundenSammlung.kundenSammlungNummer);

				System.out.print("NEU ");
				changingKundenSammlung.kundenSammlungNummer = KundenSammlung.setKundenSammlungNummer(scanner,
						testSchleife, eingabeString);
				System.out.print("NEU ");
				changingKundenSammlung.kundenSammlungNameString = KundenSammlung.setKundenSammlungName(scanner,
						testSchleife, eingabeString);
				mapAlleKundenStrukturen.put(changingKundenSammlung.kundenSammlungNummer, changingKundenSammlung);
			}
		}

		// KundenSammlungsFunktionenAllgemein
		//////////////////////////////////////////////////////
		//////////////////////////////////////////////////////
		// Veraenderungen IN KundenSammlungen

		public static int kundenZuKundenSammlungHinzufuegen(boolean testSchleife, String eingabeString, Scanner scanner,
				KundenSammlungFunktionen ausgewahelteKundenSammlung) {
			/*
			 * In dieser Methode kann der User einen neuen oder bestehenden Kunden zur
			 * KundenSammlungMap welche DIESE Methode aufruft, hinzuzufuegen;
			 */
			do {
				System.out.println(
						"[0]Abbrechen\n[1]Einen Neuen Kunden erstellen und hinzufuegen\n[2]Einen bestehenden Kunden hinzufuegen");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 2, false, false, false, false,
						false, false);
			} while (testSchleife == true);

			if (eingabeString.equals("1")) {
				/*
				 * Hier erstellt der User einen ganz neuen Kunden welcher zur map des aktuellen
				 * KundenSammlungsObjekts hinzugefuegt wird; Der neuee Kunde wird zusaetzlich zu
				 * mapAlleKundenMap hinzugefuegt;
				 */
				Kunde newKundeFuerKundenSammlungKunde = Kunde.ErstelleKunde.erstelleKunde(testSchleife, eingabeString,
						scanner);
				ausgewahelteKundenSammlung.mapKundenSammlungMap.put(newKundeFuerKundenSammlungKunde.getKundenNummer(),
						newKundeFuerKundenSammlungKunde);
				System.out.println("Kunde wurde hinzugefuegt");
			}
			if (eingabeString.equals("2")) {
				/*
				 * Dem User werden alle Kunden ausgegeben; Danach hat er durch eingabe einer
				 * existierenden KundenNummer die Wahl, diesen Kunden zur KundenSammlung welche
				 * DIESE Methode aufruft, hinzuzufuegen;
				 */
				Kunde newKundeFuerKundenSammlungKunde = nimmBestehendenKunden(testSchleife, eingabeString, scanner);
				ausgewahelteKundenSammlung.mapKundenSammlungMap.put(newKundeFuerKundenSammlungKunde.getKundenNummer(),
						newKundeFuerKundenSammlungKunde);
				System.out.println("Kunde wurde hizugefuegt");
			} else {
				// Vorgang abbgebrochen
			}
			return Integer.parseInt(eingabeString);
		}

		public static Kunde nimmBestehendenKunden(boolean testSchleife, String eingabeString, Scanner scanner) {
			/*
			 * Diese Methode laesst den User einen schon erstellten Kunden auswaehlen und zu
			 * einer KundenSammlung hinzufuegen;
			 */
			System.out.println("Ausgabe aller Kunden:");
			for (Integer keyInteger : KundenStrukturen.mapAlleKundenMap.keySet()) {
				System.out.println("Kundennummer: " + keyInteger + " Kundenname: "
						+ KundenStrukturen.mapAlleKundenMap.get(keyInteger).kundenNameString);
			}
			do {
				System.out.println("Kundennummer:___");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, false, false, true,
						false, false);
			} while (testSchleife == true);
			return KundenStrukturen.mapAlleKundenMap.get(Integer.parseInt(eingabeString));

		}

		public static void deleteKundeAusKundenSammlung(boolean testSchleife, String eingabeString, Scanner scanner,
				KundenSammlungFunktionen ausgewahelteKundenSammlung) {
			/*
			 * In dieser Methode hat der User die moeglichkeit einen Kunden aus einer
			 * Kundensammlung zu loeschen; Er werden alle Kunden aus
			 * this.mapKundenSammlungMap ausgegeben; Danach kann der User per Eingabe
			 * zwischen 'Abbrechen' oder einer 'KundenNummer' waehlen; Wenn eine gueltige
			 * KundenNummer eingegeben wurde, wird dieser Kunde aus
			 * this.mapKundenSammlungMap geloescht;
			 */
			for (Integer keyInteger : ausgewahelteKundenSammlung.mapKundenSammlungMap.keySet()) {
				System.out.println("Kundennummer: " + keyInteger + " Kundenname: "
						+ ausgewahelteKundenSammlung.mapKundenSammlungMap.get(keyInteger));
			}
			System.out.println("Welchen Kunden willst du loeschen?");
			do {
				System.out.println("Kundennummer:___\n[0]Abbrechen");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, true,
						false, false);
			} while (testSchleife == true);

			if (!eingabeString.equals("0")) {
				/*
				 * Erst wird ein Iterator erstellt welcher this.mapKundenSammlungMap beinhaltet;
				 * Danach wird in einer whileSchleife dieser Iterator durchsucht; Wenn die
				 * if-KontrollStruktur true ist, weil der Pointer vom Iterator mit der
				 * UserEingabe uebereinstimmt, wird der Kunde aus this.mapKundenSammlungMap
				 * geloescht,
				 */
				Iterator<Entry<Integer, Kunde>> iterator = ausgewahelteKundenSammlung.mapKundenSammlungMap.entrySet()
						.iterator();
				while (iterator.hasNext()) {

					if ((Integer.parseInt(eingabeString)) == iterator.next().getKey()) {
						iterator.remove();
					}
				}
			}
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result + ((kundenSammlungNameString == null) ? 0 : kundenSammlungNameString.hashCode());
		result = prime * result + kundenSammlungNummer;
		result = prime * result + ((mapKundenSammlungMap == null) ? 0 : mapKundenSammlungMap.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KundenStrukturen other = (KundenStrukturen) obj;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} else if (!kunde.equals(other.kunde))
			return false;
		if (kundenSammlungNameString == null) {
			if (other.kundenSammlungNameString != null)
				return false;
		} else if (!kundenSammlungNameString.equals(other.kundenSammlungNameString))
			return false;
		if (kundenSammlungNummer != other.kundenSammlungNummer)
			return false;
		if (mapKundenSammlungMap == null) {
			if (other.mapKundenSammlungMap != null)
				return false;
		} else if (!mapKundenSammlungMap.equals(other.mapKundenSammlungMap))
			return false;
		return true;
	}

}

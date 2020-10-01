package de.produkteTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import de.produkteTest.KundenStrukturen.KundenSammlungFunktionen;

public class Kunde {

	// Eigenschaften
	String kundenNameString;
	int kundenNummer;
	static Map<Integer, Produkt> mapKundenProdukte;
	Produkt produkt;
	// true = Kunde wird ueberall geloescht;
	// false = Kunde wird in bestimmtem KundenSammlungen geloescht;
	static boolean woBefindetSichDerZuLoeschendeKunde;

	// Konstruktor
	public Kunde(int kundenNummer, String kundenNameString) {
		this.kundenNameString = kundenNameString;
		this.kundenNummer = kundenNummer;
		this.mapKundenProdukte = new LinkedHashMap<>();
	}

	// Methode um Kunde zu erstellen;
	public static class ErstelleKunde {

		/*
		 * Diese Klasse behandelt das Thema Kundenerstellung; Der User bekommt durch
		 * Setter die moeglichkeit einem neuen Kunden eine Kundennummer und einen
		 * Kundennamen zu geben; Diese besagten Setter befinden sich direkt in einem
		 * newKunde Objekt; Dieses newKunde Objekt wird dann zu
		 * KundenStrukturen.mapAlleKundenMap hinzugefuegt;
		 */
		boolean testSchleife = false;
		String eingabeString = null;
		Scanner scanner = new Scanner(System.in);

		public static Kunde erstelleKunde(boolean testSchleife, String eingabeString, Scanner scanner) {
			boolean erstelleSchleife = false;
			Kunde newKunde = null;
			do {
				System.out.println("Du hast \"Kunde Erstellen gewaehlt\"\n[1]Weiter");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, false, false, false,
						false, false);
			} while (testSchleife == true);

			newKunde = new Kunde(setKundenNummer(testSchleife, eingabeString, scanner),
					setKundenName(testSchleife, eingabeString, scanner));
			KundenStrukturen.mapAlleKundenMap.put(newKunde.getKundenNummer(), newKunde);

			return newKunde;
		}

		public static int setKundenNummer(boolean testSchleife, String eingabeString, Scanner scanner) {
			/*
			 * Diese Methode gibt die Moeglichkeit dem Kunden eine Kundennummer zu geben;
			 * Diese Usereingabe wird durch eine tryCatchInteger Methode ueberprueft;
			 */
			do {
				System.out.println("Kundennummer:____");
				eingabeString = scanner.next();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, false, true, false,
						false, false);
			} while (testSchleife == true);
			return Integer.parseInt(eingabeString);
		}

		public static String setKundenName(boolean testSchleife, String eingabeString, Scanner scanner) {
			/*
			 * Diese Methode gibt die Moeglichkeit dem Kunden einen Kundennamen zu geben;
			 * Diese Usereingabe wird durch eine tryCatchInteger Methode ueberprueft;
			 */
			do {
				System.out.println("Kundenname:___");
				eingabeString = scanner.next();
				testSchleife = FehlerTest.tryCatchString(eingabeString, false, false);
			} while (testSchleife == true);
			return eingabeString;
		}
	}

	// Methoden um ein Produkt zur mapKundenMap hinzuzufuegen
	public void addProduktToKunde(Scanner scanner) {
		boolean testSchleife = false;
		boolean addSchleife = true;
		String eingabeString = null;
		do {
			System.out.println(
					"[0]Abbrechen\n[1]Ein neues Produkt erstellen und hinzufuegen\n[2]Ein bestehendes Produkt hinzufuegen");
			eingabeString = scanner.next();
			FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 2, false, false, false, false, false, false);
		} while (testSchleife == true);

		while (addSchleife == true) {
			if (eingabeString.equals("1")) {
				addNewProduktToKunde();
				System.out.println("Das Produkt wurde erstellt und hinzugefuegt");
				addSchleife = false;
			}
			if (eingabeString.equals("2")) {
				addExistingProduct();
				addSchleife = false;
			}
		}

	}

	public void addNewProduktToKunde() {
		/*
		 * Wenn der User diese Auswahl waehlt, wird er durch Produkt.createNewProdukt();
		 * die moeglichkeit bekommen, ein neues Produkt erstellen zu koennen
		 */
		System.out.println("Sie haben \"Ein Neues Produkt erstellen gewaehlt\"");
		Produkt newProdukt = Produkt.createNewProdukt();
		this.mapKundenProdukte.put(newProdukt.getProduktNummer(), newProdukt);
	}

	public void addExistingProduct() {
		/*
		 * Durch diese Userwahl kann man ein bestehendes Produkt in mapProdukteMap
		 * finden und zu mapKundeMap hinzufuegen
		 */
		System.out.println(
				"Sie haben \"Bestehendes Produkt hinzufuegen\" gewaehlt\n========================================================");
		Produkt newProdukt = Produkt.getProdukt();
		if (newProdukt != null) {
			this.mapKundenProdukte.put(newProdukt.getProduktNummer(), newProdukt);
			System.out.println("Das Produkt wurde gefunden und hinzugefuegt");
		}
	}

	// Methoden um Kunden auszugeben
	
	public static void ausgabeAlleKunden() {
		for (Integer keyKundeInteger : KundenStrukturen.mapAlleKundenMap.keySet()) {
			System.out.println("Kundennummer: " + keyKundeInteger + " Kundenname: " + KundenStrukturen.mapAlleKundenMap.get(keyKundeInteger).kundenNameString);
		}
	}
	
	public static void ausgabeKundeWahl() {
		/*
		 * In dieser Methode wird der User gefragt, welchen Kunden er ausgeben lassen
		 * will; Erst muss er eine existierende KundenNummer eingeben; In einer
		 * TryCatchIntegerMethode wird die eingabe geprueft; Wenn alles passt, wird der
		 * Kunde ausgeben => ProduktNummer und ProduktName;
		 */
		int kundenNummer = 0;
		boolean testSchleife = false;
		String eingabeString = null;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Kundennummer:___\n[0]Abbruch");
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, true,
					false, false);
		} while (testSchleife);

		if (!eingabeString.equals("0")) {
			kundenNummer = Integer.parseInt(eingabeString);
			ausgabeKunde(kundenNummer);
		}
		// Indem dieser bool false ist, weiss das Programm das ein Produkt in einem
		// Kunden geloescht wird;
		Produkt.woBefindetSichDasZuLoeschendeProdukt = false;
		woBefindetSichDerZuLoeschendeKunde = true;
	}

	public static void ausgabeKunde(int kundenNummer) {
		/*
		 * Nachdem der User in ausgabeKundeWahl() eine KundenNummer gewaehlt hat, wird dieser Kunde nun
		 * ausgegeben;
		 */
		Kunde kunde = KundenStrukturen.mapAlleKundenMap.get(kundenNummer);
		System.out.println("Kundennummer: " + kunde.getKundenNummer() + " Kundenname: " + kunde.getKundenNameString());

		for (Integer key : kunde.mapKundenProdukte.keySet()) {
			System.out.println("Produktnummer: " + key + " Produkt" + kunde.mapKundenProdukte.get(key));
		}
	}

	public String getKundenNameString() {
		return kundenNameString;
	}

	// Methoden um Kunden zu Loeschen
	public static void kundeLoeschenWahl(boolean testSchleife, Scanner scanner, String eingabeString,
			int kundenSammlungsNummer) {
		/*
		 * Wenn diese Methode aktiviert wird, wird der User gefragt welchen Kunden er loeschen will;
		 * Die Eingabe wird in ein TryCatchIntegerMethode ueberprueft;
		 */
		System.out.println("Bitte waehle durch Eingabe der Kundennummer einen Kunden den du Loeschen willst.");
		do {
			System.out.println("Kundennummer:___\n[0]Abbruch");
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, true,
					false, false);
		} while (testSchleife == true);

		//true = kunde wird ueberall geloescht;
		//false = kunde wird nur in einer KundenSammlung geloescht;
		/*
		 * Die Variable woBefindetSichDerZuLoeschendeKunde findet man in den Methoden:
		 * 
		 */
		if (!eingabeString.equals("0")) {
			if (woBefindetSichDerZuLoeschendeKunde == true) {
				deleteKundeUeberall(testSchleife, scanner, eingabeString);
			}
			if (woBefindetSichDerZuLoeschendeKunde == false) {
				deleteKundeInBestimmterKundenSammlung(testSchleife, scanner, eingabeString, kundenSammlungsNummer);
			}
		}
	}

	public static void deleteKundeUeberall(boolean testSchleife, Scanner scanner, String eingabeString) {
		/*
		 * Diese Methode besteht aus eine forEachSchleife welche alle KundenSammlungen
		 * durchlaeuft; Jede KundenSammlung wird mit einem Iterator, nach dem zu
		 * loeschenden Kunden, durchsucht; Wenn der Pointer des Iterators mit dem Kunden
		 * uebereinstimmt, wird dieser aus der Datenstruktur entfernt; Somit wird der
		 * Kunde aus jeder Datenstruktur entfernt;
		 */
		for (Integer keyKundenSammlung : KundenStrukturen.mapAlleKundenStrukturen.keySet()) {
			Iterator<Entry<Integer, Kunde>> iterator = KundenStrukturen.mapAlleKundenStrukturen
					.get(keyKundenSammlung).mapKundenSammlungMap.entrySet().iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getKey() == Integer.parseInt(eingabeString)) {
					iterator.remove();
				}
			}
		}
	}

	public static void deleteKundeInBestimmterKundenSammlung(boolean testSchleife, Scanner scanner,
			String eingabeString, int kundenSammlungsNummer) {
		/*
		 * Diese Methode erstellt einen Iterator welcher durch kundenSammlungsNummer
		 * weiss, aus welcher KundenSammlung er den Kunden entfernen soll;
		 */
		boolean kundeExistiertInKundenSammlung = false;
		Iterator<Entry<Integer, Kunde>> iterator = KundenStrukturen.mapAlleKundenStrukturen
				.get(kundenSammlungsNummer).mapKundenSammlungMap.entrySet().iterator();
		while (iterator.hasNext() == true) {
			if (iterator.next().getKey() == Integer.parseInt(eingabeString)) {
				iterator.remove();
				kundeExistiertInKundenSammlung = true;
			}
		}

		if (kundeExistiertInKundenSammlung == false) {
			System.out.println("Diese Kundensammlung besitzt diesen Kunden nicht");
		}
	}

	// Methoden um Kunden zu bearbeiten
	public static void editKundenAuswahl(boolean testSchleife, String eingabeString, Scanner scanner) {
		/*
		 * Diese Methode Editiert Kunden; Als erstes kann der User durch Eingabe einer
		 * Kundennummer einen Kunden auswaehlen; Solange der User nicht [0]Abbruch waehlt,
		 * wird editKunde() aufgerufen; editKunde() laesst den User entscheiden ob er
		 * die KundenNummer oder den KundenNamen editieren will;
		 */
		System.out.println("Welchen Kunden willst du bearbeiten");
		do {
			System.out.println("Kundennummer:___\n[0]Abbruch");
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, true,
					false, false);
		} while (testSchleife == true);

		if (!eingabeString.equals("0")) {
			/*
			 * Als erstes wird eine Kopie (changingKunde) vom KundenObjekt erstellt => Diese
			 * Kopie wird dann zum editieren genutzt; Dann wird die changingKunde Kopie
			 * durch editKunde() editiert; In deleteAndUpdateChangingKundeToKundenSammlung()
			 * wird dann das alte KundenObjekt durch das neue (changingKunde) ersetzt;
			 */
			Kunde changingKunde = KundenStrukturen.mapAlleKundenMap.get(Integer.parseInt(eingabeString));
			changingKunde = editKunde(testSchleife, eingabeString, scanner, changingKunde);
			deleteAndUpdateChangingKundeToKundenSammlung(testSchleife, scanner, eingabeString, changingKunde);
		}
	}

	public static Kunde editKunde(boolean testSchleife, String eingabeString, Scanner scanner, Kunde changingKunde) {
		/*
		 * In einer doWhileSchleife wird der User gefragt, ob er entweder die
		 * KundenNummer oder den KundenNamen veraendern will; Wenn er sich fuer eine der
		 * moeglichkeiten entschieden hat, wird in einer IfKontrollStruktur ein Setter
		 * fuer die Auswahlmoeglichkeiten ausgefuehrt; Dieser Setter returnt dann den
		 * veraenderten Wert an das changingKunde Objekt; Diese Objekt wird anschliesend
		 * returnt; Danach kommt wieder die Abfrage was der User machen will; Wenn er
		 * dann zum Beispiel [0]Abbrechen waehlt, wird die Methode verlasen;
		 */
		System.out.println("Nun kannst du waehlen, was du editieren willst");
		while (!eingabeString.equals("0")) {
			do {
				System.out.println("[0]Abbruch\n[1]Kundennummer\n[2]Kundenname");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 2, false, false, false, false,
						false, false);
			} while (testSchleife == true);

			if (eingabeString.equals("1")) {
				System.out.print("NEU");
				changingKunde.kundenNummer = Kunde.ErstelleKunde.setKundenNummer(testSchleife, eingabeString, scanner);
			}
			if (eingabeString.equals("2")) {
				System.out.print("NEU");
				changingKunde.kundenNameString = Kunde.ErstelleKunde.setKundenName(testSchleife, eingabeString,
						scanner);
			}
		}
		System.out.println(
				"Kundennummer: " + changingKunde.kundenNummer + " Kundenname: " + changingKunde.kundenNameString);
		return changingKunde;
	}

	public static void deleteAndUpdateChangingKundeToKundenSammlung(boolean testSchleife, Scanner scanner,
			String eingabeString, Kunde changingKunde) {
		/*
		 * Diese Methode durchlaeuft in zwei geschachtelten forEachSchleifen alle
		 * KundenSammlugen und deren mapKundenSammlungMap, also dort wo die Kunden
		 * gespeichert sind; Wenn eine KundenSammlung den zu editierenden Kunden besitzt,
		 * wird dieser mit deleteKundeInBestimmterKundenSammlung() entfernt; Danach wird
		 * der neue changingKunde zu dieser KundenSammlung hinzugefuegt;
		 */
		// Alle KundenSammlungen werden "angeschaut";
		for (Integer keyKundenSammlung : KundenStrukturen.mapAlleKundenStrukturen.keySet()) {

			// Hier wird dann die mapKundenSammlungMap nach dem Kunden durchsucht;
			for (Integer keyKunden : KundenStrukturen.mapAlleKundenStrukturen
					.get(keyKundenSammlung).mapKundenSammlungMap.keySet()) {

				// Wenn der Kunde gefunden wurde, wird er erst geloescht und danach gleich durch
				// changingKunde ersetzt;
				if (keyKunden == Integer.parseInt(eingabeString)) {
					deleteKundeInBestimmterKundenSammlung(testSchleife, scanner, eingabeString, keyKundenSammlung);
					KundenStrukturen.mapAlleKundenStrukturen.get(keyKundenSammlung).mapKundenSammlungMap
							.put(changingKunde.getKundenNummer(), changingKunde);
				}
			}
		}

	}

	public void setKundenNameString(String kundenNameString) {
		this.kundenNameString = kundenNameString;
	}

	public int getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
	}
}

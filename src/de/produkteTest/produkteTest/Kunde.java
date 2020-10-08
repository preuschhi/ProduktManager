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
	String kundenTelefonNummer;
	String kundenAdresse;
	String kundenAnsprechPartnerString;
	Map<Integer, Produkt> mapKundenProdukte;
	Produkt produkt;

	// Konstruktor
	public Kunde(int kundenNummer, String kundenNameString, String kundenTelefonNummer, String kundenAdresse,
			String kundenAnsprechPartnerString) {
		this.kundenNameString = kundenNameString;
		this.kundenNummer = kundenNummer;
		this.kundenTelefonNummer = kundenTelefonNummer;
		this.kundenAdresse = kundenAdresse;
		this.kundenAnsprechPartnerString = kundenAnsprechPartnerString;
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
				System.out.println("Du hast \"Kunde Erstellen gewaehlt\"\n[0]Abbrechen\n[1]Weiter");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 1, false, false, false, false,
						false, false);
			} while (testSchleife == true);

			if (!eingabeString.equals("0")) {
				newKunde = new Kunde(setKundenNummer(testSchleife, eingabeString, scanner),
						setKundenName(testSchleife, eingabeString, scanner),
						setKundenTelefonNummer(testSchleife, eingabeString, scanner),
						setKundenAdresse(testSchleife, eingabeString, scanner),
						setKundenAnsprechPartner(testSchleife, eingabeString, scanner));
				KundenStrukturen.mapAlleKundenMap.put(newKunde.getKundenNummer(), newKunde);
			}
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
				testSchleife = FehlerTest.tryCatchString(eingabeString, false, false, false);
			} while (testSchleife == true);
			return eingabeString;
		}

		public static String setKundenTelefonNummer(boolean testSchleife, String eingabeString, Scanner scanner) {
			// Hier wird die Telefonnummer des Kunden bestimmt;
			do {
				System.out.println("Telefonnummer:___");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchString(eingabeString, false, false, true);
			} while (testSchleife == true);

			return eingabeString;
		}

		public static String setKundenAdresse(boolean testSchleife, String eingabeString, Scanner scanner) {
			// Hier wird die Adresse des Kunden bestimmt;
			System.out.println("Kundenadresse:___");
			eingabeString = scanner.nextLine();
			return eingabeString;
		}

		public static String setKundenAnsprechPartner(boolean testSchleife, String eingabeString, Scanner scanner) {
			// Hier wird der Name des Ansprechpartners bestimmt;
			System.out.println("Ansprechpartner");
			do {
				System.out.println("Name:___");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchString(eingabeString, false, false, false);
			} while (testSchleife == true);

			return eingabeString;
		}

	}

	// Methoden um ein Produkt zur mapKundenMap hinzuzufuegen
	public static void addProduktToKunde(Boolean testSchleife, String eingabeString, Scanner scanner,
			Kunde ausgewaehlterKunde) {
		do {
			System.out.println(
					"[0]Abbrechen\n[1]Ein neues Produkt erstellen und hinzufuegen\n[2]Ein bestehendes Produkt hinzufuegen");
			eingabeString = scanner.next();
			FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 2, false, false, false, false, false, false);
		} while (testSchleife == true);

		if (eingabeString.equals("1")) {
			addNewProduktToKunde(ausgewaehlterKunde);
			System.out.println("Das Produkt wurde erstellt und hinzugefuegt");
		}
		if (eingabeString.equals("2")) {
			addExistingProduct(ausgewaehlterKunde);
		}
	}

	public static void addNewProduktToKunde(Kunde ausgewaehlterKunde) {
		/*
		 * Wenn der User diese Auswahl waehlt, wird er durch Produkt.createNewProdukt();
		 * die moeglichkeit bekommen, ein neues Produkt erstellen zu koennen
		 */
		System.out.println("Sie haben \"Ein Neues Produkt erstellen gewaehlt\"");
		Produkt newProdukt = Produkt.createNewProdukt();
		ausgewaehlterKunde.mapKundenProdukte.put(newProdukt.getProduktNummer(), newProdukt);
	}

	public static void addExistingProduct(Kunde ausgewaehlterKunde) {
		/*
		 * Durch diese Userwahl kann man ein bestehendes Produkt in mapProdukteMap
		 * finden und zu mapKundeMap hinzufuegen
		 */
		System.out.println(
				"Sie haben \"Bestehendes Produkt hinzufuegen\" gewaehlt\n========================================================");
		Produkt newProdukt = Produkt.getProdukt();
		if (newProdukt != null) {
			ausgewaehlterKunde.mapKundenProdukte.put(newProdukt.getProduktNummer(), newProdukt);
			System.out.println("Das Produkt wurde gefunden und hinzugefuegt");
		}
	}

	// Methoden um Produkte aus mapKundenProdukteMap zu loeschen
	public static void deleteProduktVonKundeWahl(boolean testSchleife, String eingabeString, Scanner scanner,
			Kunde ausgewaehlterKunde) {
		System.out.println("Durch Eingabe einer Produktnummer kannst du dieses Produkt loeschen");
		do {
			System.out.println("Produktnummer:___\n[0]Abbruch");
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, true, false, false, false,
					false, false);
		} while (testSchleife == true);

		if (!eingabeString.equals("0")) {
			deleteProduktVonKunde(testSchleife, scanner, eingabeString, ausgewaehlterKunde);
		}
	}

	public static void deleteProduktVonKunde(boolean testSchleife, Scanner scan, String eingabeString,
			Kunde ausgewaehlterKunde) {
		/*
		 * Diese Methode dursucht mithilfe eines Iterators die mapKundenProdukte des
		 * Kunden von dem das Produkt geloescht werden soll;
		 */
		/*
		 * Wenn dieser bool true bleibt, bedeutet dies, das der Kunde das zu loeschende
		 * Produkt nicht besitzt;
		 */
		boolean kundeBesitztDasProduktNicht = true;
		Iterator<Entry<Integer, Produkt>> iterator = KundenStrukturen.mapAlleKundenMap
				.get(ausgewaehlterKunde.kundenNummer).mapKundenProdukte.entrySet().iterator();
		while (iterator.hasNext()) {
			if (Integer.parseInt(eingabeString) == iterator.next().getKey()) {
				iterator.remove();
				kundeBesitztDasProduktNicht = false;
			}
		}
		if (kundeBesitztDasProduktNicht == true) {
			System.out.println("Der Kunde hat das zu loeschende Produkt nicht in seinem Inventar");
		}
	}

	// Methoden um Kunden auszugeben

	public static void ausgabeAlleKunden() {
		for (Integer keyKundeInteger : KundenStrukturen.mapAlleKundenMap.keySet()) {
			System.out.println("Kundennummer: " + keyKundeInteger + " Kundenname: "
					+ KundenStrukturen.mapAlleKundenMap.get(keyKundeInteger).kundenNameString);
		}
	}

	public static Kunde ausgabeKundeWahl() {
		/*
		 * In dieser Methode wird der User gefragt, welchen Kunden er ausgeben lassen
		 * will; Erst muss er eine existierende KundenNummer eingeben; In einer
		 * TryCatchIntegerMethode wird die eingabe geprueft; Wenn alles passt, wird der
		 * Kunde ausgeben => toStringBig, also alle Infos zum Kunden;
		 */
		int kundenNummer = 0;
		boolean testSchleife = false;
		String eingabeString = null;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("[0]Abbruch\nKundennummer:___");
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, true,
					false, false);
		} while (testSchleife);

		if (!eingabeString.equals("0")) {
			System.out.println("========================================================");
			ausgabeKunde(Integer.parseInt(eingabeString));
		}
		return KundenStrukturen.mapAlleKundenMap.get(Integer.parseInt(eingabeString));
	}

	public static void ausgabeKunde(int kundenNummer) {
		/*
		 * Nachdem der User in ausgabeKundeWahl() eine KundenNummer gewaehlt hat, wird
		 * dieser Kunde nun ausgegeben;
		 */
		Kunde kunde = KundenStrukturen.mapAlleKundenMap.get(kundenNummer);
		System.out.println(kunde.toStringBig());
		System.out.println("-------------------------------------------");
		for (Integer key : kunde.mapKundenProdukte.keySet()) {
			System.out
					.println("Produktnummer: " + key + " Produkt" + kunde.mapKundenProdukte.get(key).produktNameString);
		}
	}

	public static void ausgabeProduktInKunde(Scanner scanner, String eingabeString, boolean testSchleife) {
		/*
		 * Mit dieser Methode kann man ein Produkt eines Kunden ausgeben lassen; Es
		 * werden durch Produkt.toStringBig, alle Informationen des Produktes angezeigt;
		 */
		System.out.println("Produkt ausgeben lassen.");
		Produkt.getProdukt();
	}

	public String toStringSmall() {
		return "Kundennummer: " + kundenNummer + " Kundenname: " + kundenNameString;
	}

	public String toStringBig() {
		return "Kundennummer: " + kundenNummer + "	Kundenname: " + kundenNameString + "\nAnsprechpartner: "
				+ kundenAnsprechPartnerString + "\nTelefonnummer: " + kundenTelefonNummer + "\nAdresse: "
				+ kundenAdresse;

	}

	public String getKundenNameString() {
		return kundenNameString;
	}

	// Methoden um Kunden zu Loeschen
	public static void deleteKundeWahl(boolean testSchleife, Scanner scanner, String eingabeString) {
		/*
		 * Wenn diese Methode aktiviert wird, wird der User gefragt welchen Kunden er
		 * loeschen will; Die Eingabe wird in ein TryCatchIntegerMethode ueberprueft;
		 */
		System.out.println("Bitte waehle durch Eingabe der Kundennummer einen Kunden den du Loeschen willst.");
		do {
			System.out.println("Kundennummer:___\n[0]Abbruch");
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false, true,
					false, false);
		} while (testSchleife == true);

		if (!eingabeString.equals("0")) {
			deleteKundeUeberall(testSchleife, scanner, eingabeString);
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
		/*
		 * Es wird in einer forSchleife ein Iterator erstellt; Die forSchleife lauft
		 * solange, wie mapAlleKundenMap Elemente hat; Wenn der pointer, also
		 * hasNext().getKey mit der eingabeString, also der KundenNummer uebereinstimmt,
		 * wird der Kunde aus mapAlleKundenMap entfernt;
		 */
		for (Iterator<Entry<Integer, Kunde>> iterator = KundenStrukturen.mapAlleKundenMap.entrySet()
				.iterator(); iterator.hasNext();) {
			if (iterator.next().getKey() == Integer.parseInt(eingabeString)) {
				iterator.remove();
			}
		}
	}

	// Methoden um Kunden zu bearbeiten
	public static void editKundenAuswahl(boolean testSchleife, String eingabeString, Scanner scanner) {
		/*
		 * Diese Methode Editiert Kunden; Als erstes kann der User durch Eingabe einer
		 * Kundennummer einen Kunden auswaehlen; Solange der User nicht [0]Abbruch
		 * waehlt, wird editKunde() aufgerufen; editKunde() laesst den User entscheiden
		 * ob er die KundenNummer oder den KundenNamen editieren will;
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
				System.out.println(
						"[0]Abbruch\n[1]Kundennummer\n[2]Kundenname\n[3]Telefonnummer\n[4]Adresse\n[5]Ansprechpartner");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 5, false, false, false, false,
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
			if (eingabeString.equals("3")) {
				System.out.print("NEU");
				changingKunde.kundenNameString = Kunde.ErstelleKunde.setKundenTelefonNummer(testSchleife, eingabeString,
						scanner);
			}
			if (eingabeString.equals("4")) {
				System.out.print("NEU");
				changingKunde.kundenNameString = Kunde.ErstelleKunde.setKundenAdresse(testSchleife, eingabeString,
						scanner);
			}
			if (eingabeString.equals("5")) {
				System.out.print("NEU");
				changingKunde.kundenNameString = Kunde.ErstelleKunde.setKundenAnsprechPartner(testSchleife,
						eingabeString, scanner);
			}
		}
		System.out.println(changingKunde.toStringBig());
		return changingKunde;
	}

	public static void deleteAndUpdateChangingKundeToKundenSammlung(boolean testSchleife, Scanner scanner,
			String eingabeString, Kunde changingKunde) {
		/*
		 * Diese Methode durchlaeuft in zwei geschachtelten forEachSchleifen alle
		 * KundenSammlugen und deren mapKundenSammlungMap, also dort wo die Kunden
		 * gespeichert sind; Wenn eine KundenSammlung den zu editierenden Kunden
		 * besitzt, wird dieser mit deleteKundeInBestimmterKundenSammlung() entfernt;
		 * Danach wird der neue changingKunde zu dieser KundenSammlung hinzugefuegt;
		 */
		// Alle KundenSammlungen werden "angeschaut";
		for (Integer keyKundenSammlung : KundenStrukturen.mapAlleKundenStrukturen.keySet()) {

			// Hier wird dann die mapKundenSammlungMap nach dem Kunden durchsucht;
			for (Integer keyKunden : KundenStrukturen.mapAlleKundenStrukturen
					.get(keyKundenSammlung).mapKundenSammlungMap.keySet()) {

				// Wenn der Kunde gefunden wurde, wird er erst geloescht und danach gleich durch
				// changingKunde ersetzt;
				if (keyKunden == Integer.parseInt(eingabeString)) {
					deleteKundeUeberall(testSchleife, scanner, eingabeString);
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

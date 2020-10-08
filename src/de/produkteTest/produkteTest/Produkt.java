package de.produkteTest;

import java.util.*;
import java.util.Map.Entry;

public class Produkt {

	// Eigenschaften
	String produktNameString;
	int produktNummer;
	double produktPreis;
	int produktMHD;
	FehlerTest fehlerTest;
	// In dieser Map befinden sich alle Produkte;
	static Map<Integer, Produkt> mapProdukteMap = new LinkedHashMap<>();
	// true = Produkt wird ueberall geloescht;
	// false = Produkt wird in bestimmtem Kunden geloescht;
	static boolean woBefindetSichDasZuLoeschendeProdukt;

	// Konstruktor
	public Produkt(String produktNameString, int produktNummer, double produktPreis, int produktMHD) {
		this.produktNameString = produktNameString;
		this.produktNummer = produktNummer;
		this.produktPreis = produktPreis;
		this.produktMHD = produktMHD;
	}

	// Methoden
	/*
	 * Das Produkt hat die createNewProdukt Methode. In dieser Methode werden
	 * produktNameString, produktNummer, produktPreis und produktMHD fuer ein neues
	 * Produkt abgefragt und hinzugefuegt.
	 */
	public static Produkt createNewProdukt() {

		Scanner scan = new Scanner(System.in);
		boolean testSchleife = false;
		// Diese Variablen dienen den Methoden, das sie sie nicht selber initialisieren
		// muessen;
		int eingabeInt = 0;
		String eingabeString = null;
		double eingabeDouble = 0.0d;

		// Abfrage fuer den Produktnamen
		String produktNameString = setProduktNameString(testSchleife, eingabeString, scan);

		// Abfrage fuer die Produktnummer
		int produktNummer = setProduktNummer(testSchleife, eingabeString, scan);

		// Abfrage fuer den produktPreis
		double produktPreis = setProduktPreis(testSchleife, eingabeString, scan);

		// Abfrage fuer die ProduktMHD Dauer
		int produktMHD = setProduktMHD(testSchleife, scan, eingabeString);

		Produkt newProdukt = new Produkt(produktNameString, produktNummer, produktPreis, produktMHD);
		System.out.println("Neu erstelltes Produkt:");
		System.out.println(newProdukt.toStringBig());

		// Das newProdukt wird zu listProdukteList hinzugefuegt damit es fuer weitere
		// Schritte genutzt werden kann
		mapProdukteMap.put(newProdukt.produktNummer, newProdukt);
		return newProdukt;
	}

	public static void showMapProdukteMapSmall() {
		// Es wird die gesamte listProduktList ausgegeben
		for (Integer key : mapProdukteMap.keySet()) {
			System.out.println(mapProdukteMap.get(key).toStringSmall());
		}
	}

	public static Produkt getProdukt() {
		// Man kann eine bestimmtes Produkt auswaehlen und anzeigen lassen
		boolean testSchleife = false;// Dieser bool steuert die Testschleife;true = Abgrage wird wiederholt false =
										// Der Vorgang wurde Abgebrochen oder die Eingabe war Korrekt;
		
		Produkt geholtesProdukt = null;// In diesem Objekt wird das gewuenschte Produkt gespeichert;
		String eingabeString = null;// Hier wird die Usereingabe gespeichert;
		Scanner scanner = new Scanner(System.in);
		/*
		 * Der user hat die Wahl den Vorgang abzubrechen[0], oder eine Produktnummer
		 * einzugeben; Diese Eingabe wird in einem trycatch Block geprueft; Unteranderem
		 * wird gecheckt ob das gewuenschte Produkt existiert; Wenn dies nicht der Fall
		 * ist, wird der Vorgang abgebrochen;
		 */
		do {
			System.out.println("[0]Abbrechen\nBitte Produktnummer eingeben:___");
			eingabeString = scanner.next();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, true, false, false, false,
					false, false);
		} while (testSchleife == true);

		/*
		 * Diese Schleife ist solange aktiv, bis der User den Vorgang abbricht;
		 * eingabeString wird zu einem Integer umegewandelt um das Produkt mithilfe
		 * eines Keys welcher ein Integer ist zu bekommen;
		 */
		if (!eingabeString.equals("0")) {
			geholtesProdukt = mapProdukteMap.get(Integer.parseInt(eingabeString));
			System.out.println(geholtesProdukt.toStringBig());
		}
		return geholtesProdukt;

	}

	// Hier kommen die 3 Methoden um das newProdukt Objekt gestalten zu können
	/*
	 * Diese 3 Methoden sind so gestaltet das sie erst Abgfragen wie die jeweiligen
	 * Produkteigenschaften benannt werden sollen. Danach wird die Eingabe getestet.
	 * Bei Bedarf wird die Abfrage wiederholt.
	 */
	public static String setProduktNameString(boolean testSchleife, String eingabeString, Scanner scan) {
		// produktName
		/*
		 * Diese Methode gibt dem erstellten Produkt den Produktnamen; In einer
		 * tryCatchStringMethode wird getestet ob die Usereingabe korrekt ist;
		 */
		do {
			System.out.println("Produktname:_____");
			eingabeString = scan.next();
			System.out.println("-------------------------------------------------");
			testSchleife = FehlerTest.tryCatchString(eingabeString, false, false, false);
		} while (testSchleife == true);
		return eingabeString;
	}

	public static int setProduktNummer(boolean testSchleife, String eingabeString, Scanner scan) {
		// Produktnummer
		/*
		 * Diese Methode gibt dem erstellten Produkt die Produktnummer; In einer
		 * trycatchMehtode wird getestet ob die Usereingabe Korrekt ist;
		 */
		do {
			System.out.println("Produktnummer:___");
			eingabeString = scan.next();
			System.out.println("-------------------------------------------------");
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, true, false, false,
					false, false);
		} while (testSchleife == true);
		return Integer.parseInt(eingabeString);
	}

	public static double setProduktPreis(boolean testSchleife, String eingabeString, Scanner scan) {
		do {
			System.out.println("Produktpreis: __.__€");
			eingabeString = scan.next();
			System.out.println("-------------------------------------------------");
			testSchleife = FehlerTest.tryCatchDouble(eingabeString);
		} while (testSchleife == true);
		return Double.parseDouble(eingabeString);
	}

	public static int setProduktMHD(boolean testSchleife, Scanner scan, String eingabeString) {
		// produktMHD
		do {
			System.out.println("ProduktMHD dauer: ___ in Tagen");
			eingabeString = scan.next();
			System.out.println("-------------------------------------------------");
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, false, false, false,
					false, false);
		} while (testSchleife == true);
		return Integer.parseInt(eingabeString);
	}

	public static void deleteProduktWahl(boolean testSchleife, Scanner scan, String eingabeString) {
		/*
		 * Diese Methode hat den Zweck, das der User waehlen kann, welche Produkt er
		 * loeschen will; Er gibt per Eingabe eine ProduktNummer ein; Diese wird in
		 * einer TryCatchIntegerMethode ueberprueft; Wenn es keinen Error gibt, wird das
		 * gewaehlte Produkt unwiderruflich ueberall entfernt;
		 */
		System.out.println("Welches Produkt willst du loeschen?");
		do {
			System.out.println("Produktnummer:___\n[0]Abbruch");
			eingabeString = scan.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, true, false, false, false,
					false, false);
		} while (testSchleife == true);

		if (!eingabeString.equals("0")) {
			deleteProduktKomplett(testSchleife, scan, eingabeString);
			System.out.println("Das Produkt wurde unwiederruflich geloescht");
		}
	}

	public static void deleteProduktKomplett(boolean testSchleife, Scanner scan, String eingabeString) {
		/*
		 * Diese Methode durchsucht mithilfe einer for-each-Schleife mapAlleKundenMap;
		 * Im Kunden wird dann ein Iterator mapKundenProdukte nach dem zu loeschenden
		 * Produkt durchsuchen; Wenn der Kunde das Produkt besitzt, wird es geloescht;
		 * Zudem wird das Produkt auch in mapProdukteMap geloescht, somit ist es
		 * komplett verloren;
		 */
		// Es wird jeder Kunde durchsucht;
		for (Integer keyKunden : KundenStrukturen.mapAlleKundenMap.keySet()) {
			/*
			 * Die Map in der die Produkte eines Kunden gespeichert sind werden durchsucht;
			 * Wenn der Kunde das gewuenschte Produkt besitzt, wird es in einem Iterator
			 * geloescht;
			 */
			//Hier wird das Produkt aus allen mapKundenProdukteMap`s entfernt;
			Iterator<Entry<Integer, Produkt>> iterator = KundenStrukturen.mapAlleKundenMap
					.get(keyKunden).mapKundenProdukte.entrySet().iterator();
			while (iterator.hasNext()) {
				if (Integer.parseInt(eingabeString) == iterator.next().getKey()) {
					iterator.remove();
				}
			}
			//Hier wird das Produkt aus mapProdukteMap entfernt;
			//Hier befinden sich alle Erstellten Produkte standartmaesig;
			Iterator<Entry<Integer, Produkt>> iterator2 = mapProdukteMap.entrySet().iterator();
			while (iterator2.hasNext()) {
				if (Integer.parseInt(eingabeString) == iterator2.next().getKey()) {
					iterator2.remove();
				}
			}
		}
	}


	public static void editProduktWahl(boolean testSchleife, Scanner scan, String eingabeString) {
		/*
		 * In dieser Methode kann der User eine Produkt auswaehlen und editieren; Als
		 * erstes wird durch eine doWhileSchleife das Produkt ausgewaehlt; Dann wird
		 * eine Kopie (changingProdukt) von diesen Produkt erstellt => Diese Kopie wird
		 * zum editieren verwendet; In editProdukt() wird changingProdukt editiert; In
		 * deleteAndUpdateChangingProduktToKunden() wird das "alte" Produkt aus den
		 * Kunden entfernt und durch changingProdukt ersetzt;
		 */
		System.out.println("Welches Produkt willst du bearbeiten?");
		do {
			System.out.println("Produktnummer:___\n[0]");
			eingabeString = scan.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, true, false, false, false,
					false, false);
		} while (testSchleife == true);

		if (!eingabeString.equals("0")) {
			// Hier wird die Kopie vom Produkt erstellt;
			Produkt changingProdukt = mapProdukteMap.get(Integer.parseInt(eingabeString));
			// Hier wird das Produkt editiert;

			changingProdukt = editProdukt(testSchleife, scan, eingabeString, changingProdukt);
			// Hier wird das alte ProduktObjekt durch changingProdukt ersetzt;
			deleteAndUpdateChangingProduktToKunden(testSchleife, scan, eingabeString, changingProdukt);
		}
	}

	public static Produkt editProdukt(boolean testSchleife, Scanner scan, String eingabeString,
			Produkt changingProdukt) {
		/*
		 * Der User kann durch ZahlenEingabe entscheiden was er veraendern will; Durch
		 * Setter werden die Eigenschaften des changingProduktObjektes veraendert; Wenn
		 * der User etwas gewaehlt hat und es durch den Setter veraendert wurde, wird
		 * solange er nicht [0]Abbruch waehlte, eine whileSchleife aktiviert, welche die
		 * AuswahlMoeglichkeiten erneut anzeigt; Wenn der User [0]Abbruch waehlt, wird
		 * diese whileSchleife verlassen und das changingProduktObjekt wird returnt;
		 */
		System.out.println("Nun kannst du waehlen, was du editieren willst");
		while (!eingabeString.equals("0")) {
			do {
				System.out.println("[0]Abbruch\n[1]Produktnummer\n[2]Produktname\n[3]Produktpreis\n[4]ProduktMHD");
				eingabeString = scan.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 4, false, false, false, false,
						false, false);
			} while (testSchleife == true);

			if (eingabeString.equals("1")) {
				System.out.println("NEU");
				changingProdukt.produktNummer = setProduktNummer(testSchleife, eingabeString, scan);
			}
			if (eingabeString.equals("2")) {
				System.out.print("NEU");
				changingProdukt.produktNameString = setProduktNameString(testSchleife, eingabeString, scan);
			}
			if (eingabeString.equals("3")) {
				System.out.print("NEU");
				changingProdukt.produktPreis = setProduktPreis(testSchleife, eingabeString, scan);
			}
			if (eingabeString.equals("4")) {
				System.out.print("NEU");
				changingProdukt.produktMHD = setProduktMHD(testSchleife, scan, eingabeString);
			}
			System.out.println("Produktnummer: " + changingProdukt.produktNummer + " Produktname: "
					+ changingProdukt.produktNameString + " Produktpreis: " + changingProdukt.produktPreis
					+ " ProduktMHD: " + changingProdukt.produktMHD);
		}

		return changingProdukt;
	}

	public static void deleteAndUpdateChangingProduktToKunden(boolean testSchleife, Scanner scanner,
			String eingabeString, Produkt changingProdukt) {
		/*
		 * In dieser Methode werden in geschachtelten forEachSchleifen alle Kunden nach
		 * dem editierten ProduktObjekt durchsucht; Wenn eine Kunde dieses ProduktObjekt
		 * besitzt, wird es mit deleteProduktVonKunde() entfernt und durch das
		 * changingProduktObjekt ersetzt;
		 */
		// Alle Kunden werden "angeschaut";
		for (Integer keyKunde : KundenStrukturen.mapAlleKundenMap.keySet()) {
			// Hier wird die mapKundenMap nach dem ProduktObjekt durchsucht;
			for (Integer keyProdukt : KundenStrukturen.mapAlleKundenMap.get(keyKunde).mapKundenProdukte.keySet()) {
				// Wenn das Produkt gefunden wurde, wird es erst entfernt und dann durch
				// changingProdukt ersetzt;
				if (keyProdukt == Integer.parseInt(eingabeString)) {
					deleteProduktVonKunde(testSchleife, scanner, eingabeString, keyKunde);
					KundenStrukturen.mapAlleKundenMap.get(keyKunde).mapKundenProdukte.put(changingProdukt.getProduktNummer(),
							changingProdukt);
					deleteProduktKomplett(testSchleife, scanner, eingabeString);
					mapProdukteMap.put(changingProdukt.getProduktNummer(), changingProdukt);
				}
			}
		}
		//Hier wird das changingProdukt noch in mapProdukteMap ausgetauscht;
	}
	
	public static void deleteProduktVonKunde(boolean testSchleife, Scanner scan, String eingabeString, int kundenNummer) {
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
				.get(kundenNummer).mapKundenProdukte.entrySet().iterator();
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fehlerTest == null) ? 0 : fehlerTest.hashCode());
		result = prime * result + produktMHD;
		result = prime * result + ((produktNameString == null) ? 0 : produktNameString.hashCode());
		result = prime * result + produktNummer;
		long temp;
		temp = Double.doubleToLongBits(produktPreis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Produkt other = (Produkt) obj;
		if (fehlerTest == null) {
			if (other.fehlerTest != null)
				return false;
		} else if (!fehlerTest.equals(other.fehlerTest))
			return false;
		if (produktMHD != other.produktMHD)
			return false;
		if (produktNameString == null) {
			if (other.produktNameString != null)
				return false;
		} else if (!produktNameString.equals(other.produktNameString))
			return false;
		if (produktNummer != other.produktNummer)
			return false;
		if (Double.doubleToLongBits(produktPreis) != Double.doubleToLongBits(other.produktPreis))
			return false;
		return true;
	}

	// Hier kommen setter und getter
	public String getProduktNameString() {
		return produktNameString;
	}

	public int getProduktNummer() {
		return produktNummer;
	}

	public double getProduktPreis() {
		return produktPreis;
	}

	public int getProduktMHD() {
		return produktMHD;
	}

	public String toStringSmall() {
		return "Produktnummer: " + produktNummer + "	Produktname: " + produktNameString;
	}

	
	public String toStringBig() {
		return "Produktnummer:	" + produktNummer + "\nProduktname:	" + produktNameString
				+ "\nProduktpreis:	" + produktPreis + "€\nProduktMHD:	" + produktMHD + " Tage";
	}
	
	

}

package de.produkteTest;


import java.util.*;

public class Produkt {

	// Eigenschaften
	private String produktNameString;
	private int produktNummer;
	private double produktPreis;
	private int produktMHD;
	private int produktIndex;
	FehlerTest fehlerTest;
	static Map<Integer, Produkt> mapProdukteMap = new LinkedHashMap<>();
	public static int index = mapProdukteMap.size();

	// Konstruktor
	public Produkt(String produktNameString, int produktNummer, double produktPreis, int produktMHD, int produktIndex) {
		this.produktNameString = produktNameString;
		this.produktNummer = produktNummer;
		this.produktPreis = produktPreis;
		this.produktMHD = produktMHD;
		this.produktIndex = produktIndex;
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
		//Diese Variablen dienen den Methoden, das sie sie nicht selber initialisieren muessen;
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

		Produkt newProdukt = new Produkt(produktNameString, produktNummer, produktPreis, produktMHD,
				mapProdukteMap.size());

		// Das newProdukt wird zu listProdukteList hinzugefuegt damit es fuer weitere
		// Schritte genutzt werden kann
		mapProdukteMap.put(newProdukt.produktNummer, newProdukt);
		return newProdukt;
	}

	public static void showMapProdukteMap() {
		// Es wird die gesamte listProduktList ausgegeben
		for (Integer key : mapProdukteMap.keySet()) {
			System.out.println(mapProdukteMap.get(key));
		}
	}

	public static Produkt getProdukt() {
		// Man kann eine bestimmtes Produkt auswaehlen und anzeigen lassen
		boolean testSchleife = false;// Dieser bool steuert die Testschleife;true = Abgrage wird wiederholt false =
										// Der Vorgang wurde Abgebrochen oder die Eingabe war Korrekt;
		boolean produktWirdGeholt = true;//Dieser bool aktiviert die Schleife welche das gesuchte Produkt returnt;
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
			System.out.println("Welches Produkt soll gewählt werden?\nBitte Produktnummer eingeben\n[0]Abbrechen");
			showMapProdukteMap();
			eingabeString = scanner.next();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, true, false, false);
			if (eingabeString.equals("0")) {
				produktWirdGeholt = false;
				//testSchleife wird extra false gesetzt da tryCatchInteger sie auf true stellt;
				testSchleife = false; 
			}
		} while (testSchleife == true);

		/*
		 * Diese Schleife ist solange aktiv, bis der User den Vorgang abbricht;
		 * eingabeString wird zu einem Integer umegewandelt um das Produkt mithilfe
		 * eines Keys welcher ein Integer ist zu bekommen;
		 */
		while (produktWirdGeholt == true) {
			int eingabeZuInt = Integer.parseInt(eingabeString);
			System.out.println(mapProdukteMap.get(eingabeZuInt));
			geholtesProdukt = mapProdukteMap.get(eingabeZuInt);
			produktWirdGeholt = false;
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
		 * Diese Methode gibt dem erstellten Produkt den Produktnamen;
		 * In einer tryCatchStringMethode wird getestet ob die Usereingabe korrekt ist;
		 */
		do {
			System.out.println("Wie soll das Produkt heißen?");
			eingabeString = scan.next();
			testSchleife = FehlerTest.tryCatchString(eingabeString);
		} while (testSchleife == true);
		return eingabeString;
	}

	public static int setProduktNummer(boolean testSchleife, String eingabeString, Scanner scan) {
		// Produktnummer	
		/*
		 * Diese Methode gibt dem erstellten Produkt die Produktnummer; 
		 * In einer trycatchMehtode wird getestet ob die Usereingabe Korrekt ist;
		 */
		do {
			System.out.println("Produktnummer: ___");
			eingabeString = scan.next();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, true, false);
		} while (testSchleife == true);
		return Integer.parseInt(eingabeString);
	}

	public static double setProduktPreis(boolean testSchleife, String eingabeString, Scanner scan) {
		do {
			System.out.println("Produktpreis: __.__€");
			eingabeString = scan.next();
			testSchleife = FehlerTest.tryCatchDouble(eingabeString);
		} while (testSchleife == true);
		return Double.parseDouble(eingabeString);
	}

	public static int setProduktMHD(boolean testSchleife, Scanner scan, String eingabeString) {
		// produktMHD
		do {
			System.out.println("ProduktMHD dauer: ___ in Tagen");
			eingabeString = scan.next();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, false, false);
		} while (testSchleife == true);
		return Integer.parseInt(eingabeString);
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

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + produktIndex;
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
		if (produktIndex != other.produktIndex)
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

	@Override
	public String toString() {
		return "Produktname:" + produktNameString + ", Produktnummer: " + produktNummer + ", Produktpreis: "
				+ produktPreis + ", ProduktMHD in Tagen: " + produktMHD + ", Produktindex: " + produktIndex;
	}

}

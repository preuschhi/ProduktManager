package de.produkteTest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class Kunde {

	// Eigenschaften
	private String kundenNameString;
	private int kundenNummer;
	static Map<Integer, Produkt> mapKundenProdukte;
	Produkt produkt;
	

	// Konstruktor
	public Kunde(String kundenNameString, int kundenNummer) {
		this.kundenNameString = kundenNameString;
		this.kundenNummer = kundenNummer;
		this.mapKundenProdukte = new LinkedHashMap<>();
	}
	
	//Methode um Kunde zu erstellen;
	public static class ErstelleKunde{
		
		/*
		 * Diese Klasse behandelt das Thema Kundenerstellung;
		 * Der User bekommt durch Setter die moeglichkeit einem neuen Kunden eine Kundennummer und einen Kundennamen zu geben;
		 * Diese besagten Setter befinden sich direkt in einem newKunde Objekt;
		 * Dieses newKunde Objekt wird dann zu KundenStrukturen.mapAlleKundenMap hinzugefuegt;
		 */
		boolean testSchleife = false;
		String eingabeString = null;
		Scanner scanner = new Scanner(System.in);
		
		public static void erstelleKunde(boolean testSchleife, String eingabeString, Scanner scanner) {
			boolean erstelleSchleife = true;
			do {
				System.out.println("Du hast \"Kunde Erstellen gewaehlt\"\n[0]Abbrechen");
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, false, 0, 0, false, false, false);
			} while (testSchleife == true);
			
			//Wenn der User abbrechen will, wird der Vorgang zu denn settern abbgebrochen;
			if (eingabeString.equals("0")) {
				erstelleSchleife = false;
			}
			
			while (erstelleSchleife == true) {
				Kunde newKunde = new Kunde(setKundenName(testSchleife, eingabeString, scanner), setKundenNummer(testSchleife, eingabeString, scanner));
				KundenStrukturen.mapAlleKundenMap.put(newKunde.getKundenNummer(), newKunde); 
				erstelleSchleife = false;
			}
			
		}
		
		public static int setKundenNummer(boolean testSchleife, String eingabeString, Scanner scanner) {
			/*
			 * Diese Methode gibt die Moeglichkeit dem Kunden eine Kundennummer zu geben;
			 * Diese Usereingabe wird durch eine tryCatchInteger Methode ueberprueft;
			 */
			do {
				System.out.println("Kundennummer:____");
				eingabeString = scanner.next();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, false, 0, 0, false, false, true);
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
				testSchleife = FehlerTest.tryCatchString(eingabeString);
			} while (testSchleife == true);
			return eingabeString;
		}
	}

	// Methoden um ein Produkt zur mapKundenMap hinzuzufuegen
	public static class Produktverwaltung extends Kunde{
		//Konstruktor -> wird aber nicht benoetigt
		public Produktverwaltung(String kundenNameString, int kundenNummer) {
			super(kundenNameString, kundenNummer);
		}

		public  void addProduktToKunde(Scanner scanner) {
			boolean testSchleife = false;
			boolean addSchleife = true;
			String eingabeString = null;
			do {
				System.out.println(
						"[0]Abbrechen\n[1]Ein neues Produkt erstellen und hinzufuegen\n[2]Ein bestehendes Produkt hinzufuegen");
				eingabeString = scanner.next();
				FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 2, false, false, false);					
			} while (testSchleife == true);
			
			while (addSchleife == true){
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

		public  void addNewProduktToKunde() {
			/*
			 * Wenn der User diese Auswahl waehlt, wird er durch Produkt.createNewProdukt();
			 * die moeglichkeit bekommen, ein neues Produkt erstellen zu koennen
			 */
			System.out.println("Sie haben \"Ein Neues Produkt erstellen gewaehlt\"");
			Produkt newProdukt = Produkt.createNewProdukt();
			this.mapKundenProdukte.put(newProdukt.getProduktNummer(), newProdukt);
		}

		public  void addExistingProduct() {
			/*
			 * Durch diese Userwahl kann man ein bestehendes Produkt in mapProdukteMap
			 * finden und zu mapKundeMap hinzufuegen
			 */
			System.out.println("Sie haben \"Bestehendes Produkt hinzufuegen\" gewaehlt\n========================================================");
			Produkt newProdukt = Produkt.getProdukt();
			if (newProdukt != null) {
				this.mapKundenProdukte.put(newProdukt.getProduktNummer(), newProdukt);
				System.out.println("Das Produkt wurde gefunden und hinzugefuegt");
			} 
		}

	}


	
	public String getKundenNameString() {
		return kundenNameString;
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

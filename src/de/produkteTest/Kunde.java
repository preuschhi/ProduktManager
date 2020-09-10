package de.produkteTest;

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
		this.mapKundenProdukte = new TreeMap<>();
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
				try {
					FehlerTest.TestInteger.testInteger(eingabeString);
					FehlerTest.TestInteger.testIntegerRangeOfOptions(0, 2, eingabeString);
					FehlerTest.checkIfEingabeIs0(eingabeString);
					testSchleife = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					if (eingabeString.equals("0")) {
						testSchleife = false;
						addSchleife = false;
					}
					else {
						testSchleife = true;
					}
				}
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

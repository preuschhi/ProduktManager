package de.produkteTest;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class KundenStrukturen {

	// Eigenschaften
	Kunde kunde;
	Map<Integer, Kunde> mapAlleKundenMap;

	// Konstruktor
	public KundenStrukturen() {
		this.mapAlleKundenMap = new TreeMap<Integer, Kunde>();
	}

	public void addNewKundeToMapAlleKundenMap() {
		boolean testschleife = false;
		Scanner scanner = new Scanner(System.in);
		String eingabeString = null;
		System.out.println("Einen neuen Kunden erstellen\n[0]Abbrechen");
		do {
			System.out.println("Kundennummer:___");
			eingabeString = scanner.next();
			try {
				FehlerTest.TestInteger.testInteger(eingabeString);
				FehlerTest.checkIfEingabeIs0(eingabeString);
			} catch (Exception e) {
				testschleife = true;
				System.out.println(e.getMessage());
				if (eingabeString.equals("0")) {
					testschleife = false;
				}
			}
		} while (testschleife == true);
		
	}
}

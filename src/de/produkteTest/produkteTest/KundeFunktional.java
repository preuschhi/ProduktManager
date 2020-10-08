package de.produkteTest;

import java.util.Scanner;

public class KundeFunktional {

	/*
	 * In dieser Klasse wird die Klasse "Kunde" funktional; D.h. alle Methoden
	 * welche sich in "Kunde" befinden werden gebuendelt und zu einem
	 * AuswahlProgramm hinzugefuegt;
	 * 
	 * Der User kann: 1: Einen Kunden ausgeben => Die Produkte darin ansehen,
	 * loeschen und hinzufuegen; 2: Einen Kunden erstellen; 3: Einen Kunden
	 * loeschen;
	 */
	public static void steuerungKundenMenu(Scanner scanner, String eingabeString, boolean testSchleife) {
		// Es werden alle Kunden ausgegeben;
		Kunde.ausgabeAlleKunden();
		System.out.println("-----------------------------------");
		System.out.println(
				"[0]Zurueck\n[1]Ausgabe eines beliebigen Kunden\n[2]Erstelle einen Kunden\n[3]Loeschen eines beliebigen Kunden\n[4]Editiere einen Kunden");
		// Eingabe der Auswahl;
		do {
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 4, false, false, false, false,
					false, false);
		} while (testSchleife == true);

		if (eingabeString.equals("1")) {
			/*
			 * Wenn der User diese Auswahl gewaehlt hat, werden ihm erst alle Produkte des
			 * gewaehlten Kunden ausgegeben; Dann kann der User mit diesen Produkten
			 * interagieren. d.h. er kann: [1]Produkte hinzufuegen; [2]Produkte Loeschen;
			 * [3]Produkte mit erweiterten Inofs ausgeben lassen;
			 */
			KundeFunktional.moeglichkeitenNachBeliebigenKundenAusgeben(eingabeString, testSchleife, scanner);
		}
		if (eingabeString.equals("2")) {
			/*
			 * In dieser Auswahl, kann der User einen neuen Kunden erstellen; Der Kunde kann
			 * einen Namen und ein KundenNummer besitzen;
			 */
			Kunde.ErstelleKunde.erstelleKunde(testSchleife, eingabeString, scanner);
		}
		if (eingabeString.equals("3")) {
			/*
			 * Der User wird aufgefordert eine KundenNummer einzugeben; Danach wird dieser
			 * Kunde aus alle DatenStrukturen entfernt;
			 */
			Kunde.deleteKundeWahl(testSchleife, scanner, eingabeString);
		}
		if (eingabeString.equals("4")) {
			/*
			 * Nachdem der User eine KundenNummer eingibt, kann er die KundenNummer und den
			 * KundenNamen editieren;
			 */
			Kunde.editKundenAuswahl(testSchleife, eingabeString, scanner);
		}
	}

	public static void moeglichkeitenNachBeliebigenKundenAusgeben(String eingabeString, boolean testSchleife,
			Scanner scanner) {
		/*
		 * In dieser Methode kann der User, nachdem er einen beliebigen Kunden
		 * ausgegeben hat, die Inhalte (also die Produkte) veraendern;
		 * 
		 * 1: Er kann ein Produkt ausgeben lassen; 2: Er kann ein Produkt hinzufuegen;
		 * 3: Er kann ein Produkt entfernen;
		 */

		// Produkte von Kunde werden ausgegeben;
		Kunde ausgewaehlterKunde = Kunde.ausgabeKundeWahl();
		System.out.println("========================================================");
		do {
			System.out.println(
					"[0]Abbruch\n[1]Beliebiges Produkt ausgeben\n[2]Produkt zu Kunde hinzufuegen\n[3]Produkt von Kunde loeschen");
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 3, false, false, false, false,
					false, false);
		} while (testSchleife == true);
		if (eingabeString.equals("1")) {
			// Show Produkt;
			/*
			 * Der User kann per Eingabe einer ProduktNummer die Details besagtem Produktes
			 * ausgeben;
			 */
			Produkt.getProdukt();
		} else if (eingabeString.equals("2")) {
			// Add Produkt;
			/*
			 * Hier hat der User die moeglichkeit, ein Prdodukt zum Kunden hinzuzufuegen; Er
			 * hat die Wahl: => Ein neues Produkt zu erstellen welches dann direkt zum
			 * Kunden hinzugefuegt wird; => Oder er fuegt ein bereits erstelltes Produkt zum
			 * Kunden hinzu;
			 */
			ausgewaehlterKunde.addProduktToKunde(testSchleife, eingabeString, scanner, ausgewaehlterKunde);
		} else if (eingabeString.equals("3")) {
			// Delete Produkt;
			/*
			 * Der User kann per Eingabe der ProduktNummer ein Prdukt vom Kunden entfernen;
			 */
			Kunde.deleteProduktVonKundeWahl(testSchleife, eingabeString, scanner, ausgewaehlterKunde);
		}
	}
}

package de.produkteTest;

import java.util.Scanner;

public class ProduktFunktional {
	public static void steuerungProduktMenu(Scanner scanner, String eingabeString, boolean testSchleife) {

		/*
		 * In dieser Klasse wird die Klassen "Produkt" funktional; D.h. alle Methoden
		 * welche sich in "Produkt" befinden werden gebuendelt und zu einem
		 * AuswahlProgramm hinzugefuegt;
		 * 
		 * Der User kann Produkte erstellen, Produkte ausgeben lassen, Produkte
		 * loeschen, und er kann Produkte bearbeiten;
		 */
		/*
		 * Es werden alle Produkte ausgegeben; So kann der Kunde anhand der
		 * ProduktNummer seine Auswahl taetigen;
		 */
		System.out.println("Verfuegbare Produkte:");
		Produkt.showMapProdukteMapSmall();
		System.out.println("=================================================");
		System.out.println(
				"[0]Zurueck\n[1]Ein Produkt erstellen\n[2]Ein Produkt Suchen\n[3]Ein Produkt Loeschen\n[4]Ein Produkt bearbeiten\nEingabe:");
		do {

			eingabeString = scanner.nextLine();
			System.out.println("=================================================");
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 4, false, false, false, false,
					false, false);
		} while (testSchleife == true);

		if (eingabeString.equals("1")) {
			/*
			 * Der User kann ein neues Produkt erstellen; Dieses Produkt kann man zu Kunden
			 * hinzufuegen; Ein Produkt hat: 1: Einen Namen; 2: Eine ProduktNummer; 3: Einen
			 * Preis; 4: Ein MHD;
			 */
			System.out.println(
					"[0]Abbruch\nHier kannst du ein Produkt erstellen\n-------------------------------------------------");
			eingabeString = scanner.nextLine();
			if (!eingabeString.equals("0")) {
				Produkt.createNewProdukt();
			}
		} else if (eingabeString.equals("2")) {
			/*
			 * Hier kann der User sich zusäetzliche Infos zu einem Produkt ausgeben lassen;
			 * Preis + MHD;
			 */
			System.out.println("In dieser Map werden die Produkte durch die Produktnummer gefunden");
			Produkt.getProdukt();
		} else if (eingabeString.equals("3")) {
			System.out.println("Hier werden die Produkte allgemein geloescht");
			/*
			 * Der User soll erst eine ProduktNummer eingeben; Danach wird dieses Produkt
			 * aus allen DatenStrukturen (Auch Kunden) entfernt;
			 */
			Produkt.deleteProduktWahl(testSchleife, scanner, eingabeString);
		} else if (eingabeString.equals("4")) {
			/*
			 * Der User soll erst eine ProduktNummer eingeben; Danach kann er alle
			 * Eigenschaften dieses Produktes bearbeiten; Das Produkt wird in allen
			 * DatenStrukturen (Auch Kunden) aktualisiert;
			 */
			System.out.println("Hier werden Produkte editiert");
			Produkt.editProduktWahl(testSchleife, scanner, eingabeString);
		}
	}
}

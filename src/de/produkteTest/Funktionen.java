package de.produkteTest;

import java.util.Scanner;

public class Funktionen {

	public static void steuerungProduktMenu() {
		/*
		 * Diese Methode gibt dem user die moeglichkeit zwischen 3 Methoden
		 * (Produkt.showMapProdukteMap(), Produkt.createNewProdukt(),
		 * Produkt.getProdukt()) zu waehlen; in einem try catch block wird getestet ob
		 * eingabeString auserhalb der range ist, Symbole beinhaltet oder Buchstaben
		 * beinhaltet;
		 */
		Scanner scanner = new Scanner(System.in);
		String eingabeString;

		boolean testSchleife = false;
		do {
			System.out.println("Was willst du tun?\n[0]Das Programm beenden\n[1]Alle Produkte anzeigen"
					+ "\n[2]Ein Produkt Erstellen"
					+ "\n[3]Ein Produkt Suchen\n[4]Ein neues  Produkt einem Kunden hinzufuegen");
			eingabeString = scanner.next();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 3, false, false);
		} while (testSchleife == true);

		if (eingabeString.equals("0")) {
			System.exit(0);
		}

		if (eingabeString.equals("1")) {
			System.out.println("Hier werden alle Existierenden Produkte angezeigt.");
			Produkt.showMapProdukteMap();
		}
		if (eingabeString.equals("2")) {
			System.out.println("Hier kannst du ein neues Produkt erstellen.");
			Produkt.createNewProdukt();
		}
		if (eingabeString.equals("3")) {
			System.out.println("In dieser Map werden die Produkte durch die Produktnummer gefunden");
			Produkt.getProdukt();
		}

	}

	public static void kundenSteuerungMenu() {

	}

}

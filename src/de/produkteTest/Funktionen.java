package de.produkteTest;

import java.util.Scanner;

import de.produkteTest.KundenStrukturen.KundenSammlungFunktionen;

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

		Produkt.showMapProdukteMap();
		System.out.println("-----------------------------------------");
		System.out.println(
				"[0]Zurueck\n[1]Ein Produkt erstellen\n[2]Ein Produkt Suchen\n[3]Ein Produkt Loeschen\n[4]Ein Produkt bearbeiten");
		do {

			eingabeString = scanner.next();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 4, false, false, false, false,
					false, false);
		} while (testSchleife == true);

		if (eingabeString.equals("1")) {
			System.out.println("Hier kannst du ein Produkt erstellen");
			Produkt.createNewProdukt();
		} else if (eingabeString.equals("2")) {
			System.out.println("In dieser Map werden die Produkte durch die Produktnummer gefunden");
			Produkt.getProdukt();
		} else if (eingabeString.equals("3")) {
			System.out.println("Hier werden die Produkte allgemein geloescht");
			Produkt.deleteProduktKomplett(testSchleife, scanner, eingabeString);
		} else if (eingabeString.equals("4")) {
			System.out.println("Hier werden Produkte editiert");
			Produkt.editProduktWahl(testSchleife, scanner, eingabeString);
		}
	}

	public static void steuerungKundenMenu() {
		Scanner scanner = new Scanner(System.in);
		String eingabeString;
		boolean testSchleife = false;

		Kunde.ausgabeAlleKunden();
		System.out.println("-----------------------------------");
		System.out.println(
				"[0]Zurueck\n[1]Ausgabe eines beliebigen Kunden\n[2]Erstelle einen Kunden\n[3]Loeschen eines beliebigen Kunden\n[4]Editiere einen Kunden");
		do {
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 4, false, false, false, false,
					false, false);
		} while (testSchleife == true);

		if (eingabeString.equals("1")) {
			Kunde.ausgabeKundeWahl();
		} else if (eingabeString.equals("2")) {
			Kunde.ErstelleKunde.erstelleKunde(testSchleife, eingabeString, scanner);
		} else if (eingabeString.equals("3")) {
			Kunde.deleteKundeUeberall(testSchleife, scanner, eingabeString);
		}
	}

	public static void steuerungKundenSammlungMenu() {
		Scanner scanner = new Scanner(System.in);
		String eingabeString;
		boolean testSchleife = false;

		KundenStrukturen.KundenSammlungFunktionen.ausgabeAlleKundenSammlungen();
		System.out.println("------------------------------------------------------------");
		System.out.println(
				"[0]Zurueck\n[1]Ausgabe einer Beliebigen Kundensammlung\n[2]Erstelle eine Kundensammlung\n[3]Loesche eine beliebige Kundensammlung\n[4]Editiere eine Beliebige Kundensammlung\nEINGABE:____");
		do {
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 4, false, false, false, false,
					false, false);
		} while (testSchleife == true);

		// Ausgabe aller KundenSammlungen;

		if (eingabeString.equals("1")) {
			// Ausgabe beliebige KundenSammlung;
			KundenStrukturen.KundenSammlungFunktionen ausgewahelteKundenSammlung = (KundenSammlungFunktionen) KundenStrukturen.KundenSammlungFunktionen
					.ausgabeBeliebigeKundenSammlung(scanner, testSchleife, eingabeString);

			do {
				System.out.println("[0]Zurueck\n[1]Kunde hinzufuegen\n[2]Kunde Loeschen\n[3]Kunde Ausgeben");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 2, false, false, false, false,
						false, false);
			} while (testSchleife == true);

			if (eingabeString.equals("1")) {
				/*
				 * Der User kann: A: Einen neuen Kunden erstellen welcher anschliesend zu
				 * ausgewahelteKundenSammlung hinzugefuegt wird; Dieser neue Kunde wird
				 * Automatisch zu mapAlleKundenMap hinzugefuegt;
				 * 
				 * B: Einen bestehenden Kunden auswaehlen welcher dann zu
				 * ausgewahelteKundenSammlung hinzugefuegt wird;
				 */
				// Die wiederholungSchleife dient dazu, das der User mehrere Kunden
				// hintereinander zu einer KundenStruktur hinzufuegen kann;
				Integer wiederholungsSchleife = 1;
				while (wiederholungsSchleife != 0) {
					/*
					 * Wenn der User innerhalb der kundenZuKundenSammlungHinzufuegen() Abbrechen
					 * waehlt, also 0, wird die wiederholungsSchleife gestoppt;
					 */
					wiederholungsSchleife = KundenSammlungFunktionen.kundenZuKundenSammlungHinzufuegen(testSchleife,
							eingabeString, scanner, ausgewahelteKundenSammlung);
				}
			}
			if (eingabeString.equals("2")) {
				// Der User kann durch Eingabe einer KundenNummer einen Kunden aus der
				// KundenSammlung loeschen;
				KundenSammlungFunktionen.loescheKundeAusKundenSammlung(testSchleife, eingabeString, scanner,
						ausgewahelteKundenSammlung);
			}
			if (eingabeString.equals("3")) {
				/*
				 * Der User kann durch Eingabe einer KundenNummer diesen Kunden ausgeben lassen;
				 * Dem User werden alle Produkte welche dieser Kunde umfasst angezeigt;
				 */
				Kunde.ausgabeKundeWahl();
			}

		} else if (eingabeString.equals("2")) {
			// Erstellung einer neuen KundenSammlung;
			KundenStrukturen.KundenSammlung.erstelleKundenSammlung(scanner);
		} else if (eingabeString.equals("3")) {
			// Loeschen einer KundenSammlung;
			KundenStrukturen.KundenSammlungFunktionen.deleteBeliebigeKundenSammlung(scanner, testSchleife,
					eingabeString);
		} else if (eingabeString.equals("4")) {
			KundenStrukturen.KundenSammlungFunktionen.editBeliebigeKundenSammlung(scanner, testSchleife, eingabeString);
		}
	}

}

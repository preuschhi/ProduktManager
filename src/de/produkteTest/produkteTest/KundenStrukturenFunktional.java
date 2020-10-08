package de.produkteTest;

import java.util.Scanner;

import de.produkteTest.KundenStrukturen.KundenSammlungFunktionen;

public class KundenStrukturenFunktional {

	/*
	 * In dieser Klasse wird die Klasse "KundenStrukturen" funktional; D.h. alle
	 * Hauptsteuerungmethoden aus "KundenStrukturen" werden in einer Methode
	 * zusammengefuegt welche dann in der MainKlasse ausgefuehrt werden kann;
	 * 
	 * Man kann KundenStrukturen Ausgeben lassen: => Kunden Loeschen; => Kunden
	 * hinzufuegen; => Kunden ausgeben lassen (Produkte werden ausgegeben);
	 */

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
			moeglichkeitenNachBeliebigeKundenSammlungAusgeben(scanner, eingabeString, testSchleife);
		}
		if (eingabeString.equals("2")) {
			// Erstellung einer neuen KundenSammlung;
			KundenStrukturen.KundenSammlung.erstelleKundenSammlung(scanner);
		}
		if (eingabeString.equals("3")) {
			// Loeschen einer KundenSammlung;
			KundenStrukturen.KundenSammlungFunktionen.deleteBeliebigeKundenSammlung(scanner, testSchleife,
					eingabeString);
		}
		if (eingabeString.equals("4")) {
			KundenStrukturen.KundenSammlungFunktionen.editBeliebigeKundenSammlung(scanner, testSchleife, eingabeString);
		}
	}

	public static void moeglichkeitenNachBeliebigeKundenSammlungAusgeben(Scanner scanner, String eingabeString,
			boolean testSchleife) {
		// Ausgabe beliebige KundenSammlung;
		KundenStrukturen.KundenSammlungFunktionen ausgewahelteKundenSammlung = (KundenSammlungFunktionen) KundenStrukturen.KundenSammlungFunktionen
				.ausgabeBeliebigeKundenSammlung(scanner, testSchleife, eingabeString);
		if (ausgewahelteKundenSammlung != null) {
		do {
			System.out.println("[0]Zurueck\n[1]Kunde hinzufuegen\n[2]Kunde Loeschen\n[3]Kunde Ausgeben");
			eingabeString = scanner.nextLine();
			testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 3, false, false, false, false,
					false, false);
		} while (testSchleife == true);

		if (eingabeString.equals("1")) {
			// Hier kann der User einen Kunden zur KundenSammlung hinzufuegen;
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
		} else if (eingabeString.equals("2")) {
			// Der User kann durch Eingabe einer KundenNummer einen Kunden aus der
			// KundenSammlung loeschen;
			KundenSammlungFunktionen.deleteKundeAusKundenSammlung(testSchleife, eingabeString, scanner,
					ausgewahelteKundenSammlung);
		} else if (eingabeString.equals("3")) {
			/*
			 * Der User kann durch Eingabe einer KundenNummer diesen Kunden ausgeben lassen;
			 * Dem User werden alle Produkte welche dieser Kunde umfasst angezeigt;
			 */
			Kunde.ausgabeKundeWahl();
			moeglichkeitenNachKundenAusgebenLassen(scanner, eingabeString, testSchleife);
		}	
	}
	}
	
	public static void moeglichkeitenNachKundenAusgebenLassen(Scanner scanner, String eingabeString,
			boolean testSchleife) {
		System.out.println();
		boolean produktAusgeben = true;
			while (produktAusgeben == true) {
				
			System.out.println("[0]Abbruch\n[1]Produkt ausgeben lassen");
			do {
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, true, true, 0, 1, false, false, false, false, false, false);
			} while (testSchleife == true);
			
			if (!eingabeString.equals("0")) {
				Produkt.getProdukt();
			}
			else {
				produktAusgeben = false;
			}
		}
		}
	}


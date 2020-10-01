package de.produkteTest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import de.produkteTest.KundenStrukturen.KundenSammlung;

import de.produkteTest.KundenStrukturen.KundenSammlungFunktionen;

public class ProdukteTestMain {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		boolean testSchleife = false;
		String eingabeString = null;

		Produkt saitenProdukt = new Produkt("Saiten", 707, 5.00, 14);
		Produkt.mapProdukteMap.put(saitenProdukt.getProduktNummer(), saitenProdukt);

		System.out.println(Produkt.mapProdukteMap.size());

		Produkt knackerProdukt = new Produkt("Knacker", 720, 6.50, 24);
		Produkt.mapProdukteMap.put(knackerProdukt.getProduktNummer(), knackerProdukt);

		System.out.println(Produkt.mapProdukteMap.size());

		Produkt lyoner = new Produkt("Lyoner", 510, 2.50, 14);
		Produkt.mapProdukteMap.put(lyoner.getProduktNummer(), lyoner);

		KundenSammlungFunktionen kdSammlung = new KundenSammlungFunktionen(1234, "Harald");
		KundenStrukturen.mapAlleKundenStrukturen.put(kdSammlung.getKundenSammlungNummer(), kdSammlung);
		
		KundenSammlungFunktionen kdSammlung2 = new KundenSammlungFunktionen(2345, "Peter");	
		KundenStrukturen.mapAlleKundenStrukturen.put(kdSammlung2.getKundenSammlungNummer(), kdSammlung2);
		
		KundenSammlungFunktionen kdSammlung3 = new KundenSammlungFunktionen(3456, "Andi");
		KundenStrukturen.mapAlleKundenStrukturen.put(kdSammlung3.getKundenSammlungNummer(), kdSammlung3);
		
		KundenSammlungFunktionen kdSammlung4 = new KundenSammlungFunktionen(5432, "Delia");
		KundenStrukturen.mapAlleKundenStrukturen.put(kdSammlung4.getKundenSammlungNummer(), kdSammlung4);
		
		
		Kunde kunde = new Kunde(2003, "Dorfladen");
		KundenStrukturen.mapAlleKundenMap.put(kunde.getKundenNummer(), kunde);
		kunde.mapKundenProdukte.put(saitenProdukt.getProduktNummer(), saitenProdukt);		
		Kunde kunde2 = new Kunde(120, "Gebauer");
		KundenStrukturen.mapAlleKundenMap.put(kunde2.getKundenNummer(), kunde2);
		
		Map<Integer, Kunde> mapTestMap = new LinkedHashMap<Integer, Kunde>();
		mapTestMap.put(kunde.getKundenNummer(), kunde);
		
		
		
		
		boolean run = true;
		while ( run == true) {
			do {
				System.out.println("=================================================0\n[1]Produktoptionen\n[2]Kundensammlungenoptionen\n[3]Kundenoptionen");
				eingabeString = scanner.nextLine();
				testSchleife = FehlerTest.tryCatchInteger(eingabeString, false, true, 1, 3, false, false, false, false, false, false);
			} while (testSchleife == true);
			
			if (eingabeString.equals("1")) {
				Funktionen.steuerungProduktMenu();
			}
			if (eingabeString.equals("2")) {
				Funktionen.steuerungKundenSammlungMenu();
			}
			if (eingabeString.equals("3")) {
				Funktionen.steuerungKundenMenu();
			}
				
		}
		
		
	}

}

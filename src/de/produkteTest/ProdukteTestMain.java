package de.produkteTest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class ProdukteTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(Produkt.index);
		System.out.println(Produkt.mapProdukteMap.size());
		
		Produkt saitenProdukt = new Produkt("Saiten", 707, 5.00 , 14, Produkt.mapProdukteMap.size());
		Produkt.mapProdukteMap.put(saitenProdukt.getProduktNummer(), saitenProdukt);
		System.out.println(Produkt.index);
		System.out.println(Produkt.mapProdukteMap.size());
		
		Produkt knackerProdukt = new Produkt("Knacker", 720, 6.50 , 24, Produkt.mapProdukteMap.size());
		Produkt.mapProdukteMap.put(knackerProdukt.getProduktNummer(), knackerProdukt);
		System.out.println(Produkt.index);
		System.out.println(Produkt.mapProdukteMap.size());
		
		Produkt lyoner = new Produkt("Lyoner", 510, 2.50 , 14, Produkt.mapProdukteMap.size());
		Produkt.mapProdukteMap.put(lyoner.getProduktNummer(), lyoner);
		
		while (1 == 1) {
		Funktionen.steuerungProduktMenu();
		}
		
		
//		Scanner scanner = new Scanner(System.in);
//		Kunde.Produktverwaltung kunde2 = new Kunde.Produktverwaltung("Dorfladen", 2003);
//		kunde2.addProduktToKunde(scanner);
//		for (Integer keyInteger : kunde2.mapKundenProdukte.keySet()) {
//			System.out.println(kunde2.mapKundenProdukte.get(keyInteger));
//		}
	}

}

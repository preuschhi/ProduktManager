package de.produkteTest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import de.produkteTest.KundenStrukturen.KundenSammlung;

import de.produkteTest.KundenStrukturen.KundenSammlungFunktionen;



public class ProdukteTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		boolean testSchleife = false;
		String eingabeString = null;

		
		
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
		
		//TEST OB MAN EINZELNE KUNDENSAMMLUNGEN LOESCHEN KANN
		KundenStrukturen kdSammlung = new KundenStrukturen(1234, "Test");
		KundenStrukturen.mapAlleKundenStrukturen.put(kdSammlung.kundenSammlungNummer, kdSammlung);
		
		KundenStrukturen.KundenSammlungFunktionen kdSammlung2 = new KundenStrukturen.KundenSammlungFunktionen(2345, "Test2");
		KundenSammlung.mapAlleKundenStrukturen.put(kdSammlung2.kundenSammlungNummer, kdSammlung2);
		kdSammlung2.kundenZuKundenSammlungHinzufuegen(testSchleife, eingabeString, scanner);
		KundenSammlungFunktionen.ausgabeBeliebigeKundenSammlung(scanner, testSchleife, eingabeString);
		
		KundenStrukturen.KundenSammlung.erstelleKundenSammlung(scanner);
		
		KundenStrukturen kdSammlung3 = new KundenStrukturen(3456, "Test3");
		KundenStrukturen.mapAlleKundenStrukturen.put(kdSammlung3.kundenSammlungNummer, kdSammlung3);
		
		KundenSammlungFunktionen.ausgabeAlleKundenSammlungen();
//		KundenStrukturen.KundenSammlungFunktionen.deleteBeliebigeKundenSammlung(scanner, testSchleife, eingabeString);
		
		KundenStrukturen.KundenSammlungFunktionen.editBeliebigeKundenSammlung(scanner, testSchleife, eingabeString);
		KundenSammlungFunktionen.ausgabeAlleKundenSammlungen();
		
		//TEST FUER PRODUKTE IN KUNDEN. PRODUKT WIRD GEAENDERT;
//		Kunde.ErstelleKunde.erstelleKunde(testSchleife, eingabeString, scanner);
//		System.out.println(KundenStrukturen.mapAlleKundenMap.get(2003));
//		Kunde kunde = KundenStrukturen.mapAlleKundenMap.get(2003);
//		kunde.mapKundenProdukte.put(707, saitenProdukt);
//		
//		Kunde.ErstelleKunde.erstelleKunde(testSchleife, eingabeString, scanner);
//		System.out.println(KundenStrukturen.mapAlleKundenMap.get(1234));
//		Kunde kunde2 = KundenStrukturen.mapAlleKundenMap.get(1234);
//		kunde.mapKundenProdukte.put(707, saitenProdukt);
//
//		System.out.println(kunde.mapKundenProdukte.get(707));
//		saitenProdukt.produktNameString = saitenProdukt.setProduktNameString(testSchleife, eingabeString, scanner);
//		System.out.println(saitenProdukt.getProduktNameString());
//		
//		
//		System.out.println(kunde.mapKundenProdukte.get(707));
//		System.out.println(kunde2.mapKundenProdukte.get(707));
		
//		while (1 == 1) {
//		Funktionen.steuerungProduktMenu();
//		}
		
		

	}

}

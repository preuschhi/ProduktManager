package de.produkteTest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;




public class KundenStrukturen {

	// Eigenschaften
	Kunde kunde;
	String kundenSammlungNameString;
	static Map<Integer, Kunde> mapAlleKundenMap = new LinkedHashMap<>();
	//Diese Map bildet KundenSammlungen/ Buendelungen;
	Map<Integer, Kunde> mapKundenSammlungMap;
	//Durch diese List hat man zugriff auf mapAlleKundenMap und auf KundenSammlungen;
	static List<Map<Integer, Kunde>> kundenStrukturSammlung = new ArrayList<>();
	

	// Konstruktor
	public KundenStrukturen(String kundenSammlungNameString) {
		this.kundenSammlungNameString = kundenSammlungNameString;
		this.mapKundenSammlungMap = new LinkedHashMap<>();
	}
	
	public static class KundenSammlung{
		/*
		 * Eine KundenSammlung ist eine buendelung ausgewaehlter Kunden;
		 * Wie z.B. Gebauer, Aupperle, usw....;
		 */
		Scanner scanner = new Scanner(System.in);
		
		public static void erstelleKundenSammlung(Scanner scanner) {
		
		}
	}
}
package de.produkteTest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class FehlerTest extends Exception {
	/*
	 * In dieser Klasse werden die Usereingaben auf korrektheit ueberprueft; Bei
	 * Fehlern wird eine Fehlermeldung ausgegeben; der User wird gebeten die Eingabe
	 * zu wiederholen.
	 * 
	 */

	Produkt produkt;
	KundenStrukturen kundenStrukturen;
	static int eingabeZuInt = 0;

	public static boolean tryCatchInteger(String eingabeString, boolean checkIfEingabeIs0,
			boolean testIntegerRangeOfOptions, int min, int max, boolean checkIfProductExistInMapProdukteMap,
			boolean checkIfProduktNummerIsAvailable, boolean checkIfKundenNummerIsAvailable) {

		/*
		 * Diese tryCatchMethode fasst alle FehlerMethoden, welche sich um Integers
		 * kuemmern, zusammen;
		 */
		int eingabeStringZuInt = -1;
		//Dieser boolean wird returnt; Er steuert die testSchleife in welcher sich DIESE Methode befindet
		boolean testSchleife = false;
		try {

			// Die 2 folgenden Methoden benoetigen keine aktivierung durch einen bool;
			/*
			 * Wenn tryCatchInteger genutzt wird, erwartet das Programm einen Integer, daher
			 * ist testInteger(eingabeString) auch ohne bool aktiv; Wenn eingabeString keine
			 * Buchstaben oder Symbole enthaelt, wird eingabeString in einen Int
			 * umgewandelt, ansonsten wird eine Fehlermeldung ausgegeben;
			 */
			eingabeStringZuInt = TestInteger.testInteger(eingabeString);

			// Die weiteren Methoden werden je nach erforferlichkeit durch einen bool
			// aktiviert;
			if (checkIfEingabeIs0 == true) {
				// Diese Methode checkt ob die Usereingabe 0, also abbrechen ist;
				checkIfEingabeIs0(eingabeStringZuInt);
			}
			if (testIntegerRangeOfOptions == true) {
				// Diese Methode wird genutzt wenn der User sich zwischen einer Festgelegten
				// Anzahl an Moeglichkeiten entscheiden muss;
				TestInteger.testIntegerRangeOfOptions(min, max, eingabeStringZuInt);
			}
			if (checkIfProductExistInMapProdukteMap == true) {
				// Wenn der User ein bestimmtes Produkt sucht und Wissen muss ob es existiert
				// wird diese Methode genutzt;
				checkIfProductExistInMapProdukteMap(eingabeStringZuInt);
			}
			if (checkIfProduktNummerIsAvailable == true) {
				// Bei der Festlegung der Produktnummer eines neuen Produkts, muss getestet
				// werden ob diese noch verfuegbar ist;
				checkIfProduktNummerIsAvailable(eingabeStringZuInt);
			}
			if (checkIfKundenNummerIsAvailable == true) {
				//Wenn dieser bool true ist, wird ueberprueft ob die gewuenschte Kundennummer verfuegbar ist
				checkIfKundenNummerIsAvailable(eingabeStringZuInt);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*
			 * Wenn die Eingabe 0, also Abbrechen ist, returnt diese Methode ein false,
			 * damit die Testschleife in welcher sie sich befindet beendet wird; Wenn es
			 * einen anderen fehler gibt, wird true returnt, also die Testschleife wird
			 * aktiviert;
			 */
			if (eingabeStringZuInt == 0) {
				testSchleife = false;

			} else {
				testSchleife = true;
			}
		}
		return testSchleife;

	}

	public static boolean tryCatchString(String eingabeString) {
		/*
		 * Diese tryCatchMethode checkt ob die Usereingabe aus Buchstaben besteht; Wenn
		 * die Usereingabe Symbole oder Ziffern enthaelt wird eine Fehlermeldung
		 * ausgegeben;
		 */
		//Dieser boolean wird returnt; Er steuert die testSchleife in welcher sich DIESE Methode befindet
		boolean testSchleife = false;
		try {
			testString(eingabeString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			testSchleife = true;
		}
		return testSchleife;
	}

	public static boolean tryCatchDouble(String eingabeString) {
		/*
		 * Diese tryCatchMethode checkt ob die Usereingabe aus Ziffern und einem Punkt
		 * besteht; Wenn sie Buchstaben enthaelt oder keinen Punkt enthaelt, wird eine
		 * Fehlermeldung ausgegeben;
		 */
		//Dieser boolean wird returnt; Er steuert die testSchleife in welcher sich DIESE Methode befindet
		boolean testSchleife = false;
		try {
			testDouble(eingabeString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			testSchleife = true;
		}

		return testSchleife;
	}

	public static void testString(String eingabeString) throws FehlerTest {
		/*
		 * Diese Methode checkt ob die eingabeString Buchstaben beinhaltet;
		 * eingabeString wird in einzelne chars in checkIfEingabeContainsNumber
		 * gespeichert; checkIfEingabeContainsNumber wird dann char fuer char auf Zahlen
		 * getestet; Wenn ein char eine zahl (isDigit() = true) ist, wird eine
		 * Fehlermeldung ausgegeben.
		 */
		char[] checkIfEingabeContainsNumber = new char[eingabeString.length()];

		/*
		 * Die eingabeString wird aufgeteilt und in checkIfEingabeContainsNumber[]
		 * gespeichert
		 */
		for (int i = 0; i < eingabeString.length(); i++) {
			checkIfEingabeContainsNumber[i] = eingabeString.charAt(i);
		}

		/*
		 * Nun wird checkIfEingabeContainsNumber[] auf Symbole oder Zahlen ueberprueft;
		 * Wenn isAlphabetic() = false ist, wird eine Fehlermeldung ausgegeben
		 */
		for (char c : checkIfEingabeContainsNumber) {
			if (Character.isAlphabetic(c) == false) {
				throw new FehlerTest("Deine Eingabe darf keine Symbole oder Zahlen enthalten");
			}
		}

	}

	public static class TestInteger {
		public static int testInteger(String eingabeString) throws FehlerTest {
			/*
			 * Diese Methode checkt ob die eingabeString Zahlen beinhaltet; eingabeString
			 * wird in einzelne chars in checkIfEingabeContainsLetter[] gespeichert;
			 * checkIfEingabeContainsLetter wird dann char fuer char auf Buchstaben
			 * getestet; Wenn ein char ein Buchstabe (isDigit() = false) ist, wird eine
			 * Fehlermeldung ausgegeben.
			 */
			char[] checkIfEingabeContainsLetter = new char[eingabeString.length()];

			/*
			 * Die eingabeString wird aufgeteilt und in einem Array gespeichert Wenn
			 * checkIfEingabeContainsLetter[] einen Buchstaben oder ein Symbol enthaelt,
			 * wird eine Fehlermeldung ausgegeben.
			 */
			for (int i = 0; i < eingabeString.length(); i++) {
				checkIfEingabeContainsLetter[i] = eingabeString.charAt(i);
				if (Character.isDigit(checkIfEingabeContainsLetter[i]) == false) {
					throw new FehlerTest(
							"Deine Eingabe muss eine Zahl sein und darf keine Symbole enthalten.\n====================================================================");
				}
			}
			int eingabeStringZuInt;
			return eingabeStringZuInt = Integer.parseInt(eingabeString);
		}

		public static void testIntegerRangeOfOptions(int min, int max, int eingabeStringZuInt) throws FehlerTest {
			/*
			 * Diese Methode Testet ob die Usereingabe inerhalb der Auswahlrange ist;
			 */
			/*
			 * Hier wird auswahlEingabeRange[] erstellt um spaeter eingabeZuInt einfacher
			 * ueberpruefen zu koennen;
			 */
			Integer[] auswahlEingabeRange = new Integer[max + 1];
			for (int i = 0; i < auswahlEingabeRange.length; i++) {
				auswahlEingabeRange[i] = i;
			}
			/*
			 * Hier wird geschaut, ob eingabeStringZuInt mit mindestens einer indexStelle
			 * innerhalb auswahlEingabeRange[] uebereinstimmt; Wenn dies nicht der Fall ist,
			 * also eingabeString z.B. eine 4 statt einer 3 ist, wird eine Fehlermeldung
			 * ausgegeben;
			 */
			if (Arrays.stream(auswahlEingabeRange).anyMatch(predicate -> predicate == eingabeStringZuInt) == false) {
				throw new FehlerTest("Deine Eingabe muss eine Zahl zwischen " + min + " und " + max
						+ " sein.\n======================================================");
			}
		}
	}

	public static void testDouble(String eingabeString) throws FehlerTest {
		/*
		 * Diese Methode ueberprueft ob eingabeString Zahlen und einen . enthaelt; Wenn
		 * dies nicht der Falls ist, werden Fehlermeldungen ausgegeben
		 */
		char[] checkIfEingabeContainsDotAndLetter = new char[eingabeString.length()];

		/*
		 * Die eingabeString wird aufgeteilt und in checkIfEingabeContainsDotAndLetter[]
		 * gespeichert
		 */
		for (int i = 0; i < eingabeString.length(); i++) {
			checkIfEingabeContainsDotAndLetter[i] = eingabeString.charAt(i);
		}

		/*
		 * checkIfEingabeContainsDotAndLetter[] wird sortiert; somit kann direkt
		 * ueberprueft werden ob die erste indexStelle ein . ist, wenn dies nicht der
		 * Fall ist wird eine Fehlermeldung ausgegeben in der der user gebeten wird
		 * einen . hinzuzufuegen
		 */
		Arrays.sort(checkIfEingabeContainsDotAndLetter);
		if (checkIfEingabeContainsDotAndLetter[0] != '.') {
			throw new FehlerTest("Deine Eingabe muss ein . enthalten\n============================0");
		}
		/*
		 * Wenn checkIfEingabeContainsDotAndLetter[] einen . enthaelt, wird ueberprueft
		 * ob checkIfEingabeContainsDotAndLetter[] aus Zahlen besteht, zudem werden
		 * weitere Symbole erkannt; in einer forEach() Schleife wird mit isDigit() jede
		 * indexStelle getestet; wenn isDigit() == false ist, wird eine Fehlermeldung
		 * ausgegeben
		 */
		// Hier wird die erste indexStelle in checkIfEingabeContainsDotAndLetter[],
		// also . auf 0 gestellt damit isDigit() nicht getriggert wird
		checkIfEingabeContainsDotAndLetter[0] = '0';
		for (char c : checkIfEingabeContainsDotAndLetter) {
			if (Character.isDigit(c) == false) {
				throw new FehlerTest(
						"Deine Eingabe muss aus Zahlen bestehen und darf nur einen . enthalten\n===================================0");
			}
		}
		
		if (checkIfEingabeContainsDotAndLetter.length == 1) {
			throw new FehlerTest("Deine Eingabe muss aus mindestens 2 Zahlen und einem . bestehen");
		}
	}

	public static void checkIfProductExistInMapProdukteMap(int eingabeStringZuInt) throws FehlerTest {
		/*
		 * Diese Methode checkt ob ein vom User gewuenschtes Produkt existiert; Wenn
		 * nicht, wird eine Fehlermeldung ausgegeben
		 */
		boolean pickedProductProduktNummerFound = false;

		/*
		 * mapProdukteMap wird mit einer for each schleife durchlaufen; wenn die
		 * eingabeStringZuInt mit pickedProductProduktNummer uebereinstimmt, wird
		 * pickedProductProduktNummerFound true gesetzt damit im weiteren Verlauf eine
		 * Fehlermeldung ausgegeben wird;
		 */
		for (Integer pickedProductProduktNummer : Produkt.mapProdukteMap.keySet()) {
			if (eingabeStringZuInt == pickedProductProduktNummer) {
				pickedProductProduktNummerFound = true;
			}
		}

		if (pickedProductProduktNummerFound == false) {
			throw new FehlerTest("Diese Produktnummer existiert nicht\n====================================");
		}
	}

	public static void checkIfProduktNummerIsAvailable(int eingabeStringZuInt) throws FehlerTest {
		/*
		 * Diese Methode ueberprueft ob eine gewuenschte Produktnummer noch verfuegbar
		 * ist
		 */
		for (Integer produktNummer : Produkt.mapProdukteMap.keySet()) {
			if (eingabeStringZuInt == produktNummer) {
				throw new FehlerTest("Die Produktnummer " + eingabeZuInt + " ist schon vergeben.\n"
						+ "Gib bitte eine andere Produktnummer ein.");
			}
		}
	}

	public static void checkIfKundenNummerIsAvailable(int eingabeStringZuInt) throws FehlerTest{
		for (Integer kundenNummer : KundenStrukturen.mapAlleKundenMap.keySet()) {
			if(kundenNummer == eingabeStringZuInt) {
				throw new FehlerTest("Die Kundennummer " + kundenNummer + " ist schon vergeben.\n"
						+ "Gib bitte eine andere Kundennummer ein.");
			}
		}
	}
	
	public static void checkIfEingabeIs0(int eingabeStringZuInt) throws FehlerTest {
		/*
		 * Diese Methode checkt ob eingabeString eine 0, also abbrechen ist;
		 */
		if (eingabeStringZuInt == 0) {
			throw new FehlerTest("Der Vorgang wurde abbgebrochen");
		}
	}

	public FehlerTest(String message) {
		super(message);
	}
}

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
			boolean checkIfProduktNummerIsAvailable, boolean checkIfKundenNummerIsAvailable,
			boolean checkIfKundenNummerDoesExist, boolean checkIfKundenSammlungNummerIsAvailable,
			boolean checkIfKundenSammlungNummerDoesExist) {

		/*
		 * Diese tryCatchMethode fasst alle FehlerMethoden, welche sich um Integers
		 * kuemmern, zusammen;
		 */
		int eingabeStringZuInt = -1;
		// Dieser boolean wird returnt; Er steuert die testSchleife in welcher sich
		// DIESE Methode befindet
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
				// Wenn dieser bool true ist, wird ueberprueft ob die gewuenschte Kundennummer
				// verfuegbar ist;
				checkIfKundenNummerIsAvailable(eingabeStringZuInt);
			}
			if (checkIfKundenNummerDoesExist == true) {
				// diese Methode checkt ob die eingegebene Kundennummer existiert;
				checkIfKundenNummerDoesExist(eingabeStringZuInt);
			}
			if (checkIfKundenSammlungNummerIsAvailable == true) {
				// Hier wird geprueft ob die vom User gewaehlte KundenSammlungsNummer verfuegbar
				// ist;
				checkIfKundenSammlungNummerIsAvailable(eingabeStringZuInt);
			}
			if (checkIfKundenSammlungNummerDoesExist == true) {
				// Hier wird gecheckt, ob eine gewuenschte KundenSammlung existiert;
				checkIfKundenSammlungNummerDoesExist(eingabeStringZuInt);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*
			 * Wenn die Eingabe 0, also Abbrechen ist, returnt diese Methode ein false,
			 * damit die Testschleife in welcher sie sich befindet beendet wird; Wenn es
			 * einen anderen fehler gibt, wird true returnt, also die Testschleife wird
			 * aktiviert;
			 */
			if (checkIfEingabeIs0 == true && eingabeStringZuInt == 0) {
				testSchleife = false;

			} else {
				testSchleife = true;
			}
		}
		return testSchleife;

	}

	public static boolean tryCatchString(String eingabeString, boolean checkIfEingabeIs0,
			boolean checkIfKundenSammlungNameIsAvailable, boolean testStringTelefonNummer) {
		/*
		 * Diese tryCatchMethode checkt ob die Usereingabe aus Buchstaben besteht; Wenn
		 * die Usereingabe Symbole oder Ziffern enthaelt wird eine Fehlermeldung
		 * ausgegeben;
		 */
		// Dieser boolean wird returnt; Er steuert die testSchleife in welcher sich
		// DIESE Methode befindet
		boolean testSchleife = false;
		try {

			testString(eingabeString);

			if (checkIfEingabeIs0 == true) {
				int eingabeStringZuInt = Integer.parseInt(eingabeString);
				checkIfEingabeIs0(eingabeStringZuInt);
			}

			if (checkIfKundenSammlungNameIsAvailable == true) {
				checkIfKundenSammlungNameIsAvailable(eingabeString);
			}
			
			if (testStringTelefonNummer == true) {
				testStringTelefonNummer(eingabeString);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (checkIfEingabeIs0 == true) {
				testSchleife = false;

			} else {
				testSchleife = true;
			}
		}
		return testSchleife;
	}

	public static boolean tryCatchDouble(String eingabeString) {
		/*
		 * Diese tryCatchMethode checkt ob die Usereingabe aus Ziffern und einem Punkt
		 * besteht; Wenn sie Buchstaben enthaelt oder keinen Punkt enthaelt, wird eine
		 * Fehlermeldung ausgegeben;
		 */
		// Dieser boolean wird returnt; Er steuert die testSchleife in welcher sich
		// DIESE Methode befindet
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

	public static void testStringTelefonNummer(String eingabeString) throws FehlerTest {
		/*
		 * Diese FehlerMethode ueberprueft die Eingabe fuer die KundenTelefonNummer; Sie
		 * checkt, ob die TelefonNummer Buchstaben enthaelt; Falls ja, wird eine
		 * FehlerMeldung ausgegeben;
		 */
		/*
		 * Die Eingabe wird in einerm Array gespeichert; So kann jede einzelne Stelle
		 * ueberprueft werden;
		 */
		char[] checkIfTelefonNummerContainsLetters = new char[eingabeString.length()];
		/*
		 * Das Array wird mit einer forEachSchleife index fuer index durchlaufen;
		 * Durch die isAlphabetic Methode wrden Buchstaben erkannt;
		 */
		for (char character : checkIfTelefonNummerContainsLetters) {
			if (!Character.isAlphabetic(character)) {
				throw new FehlerTest("Die Telefonnummer darf keine Buchstaben enthalten");
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
							"FEHLER\nDeine Eingabe muss eine Zahl sein und darf keine Symbole enthalten\nFEHLER");
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
				throw new FehlerTest("Die Produktnummer " + eingabeStringZuInt + " ist schon vergeben.\n"
						+ "Gib bitte eine andere Produktnummer ein.");
			}
		}
	}

	public static void checkIfKundenNummerIsAvailable(int eingabeStringZuInt) throws FehlerTest {
		/*
		 * Diese Methode ueberprueft ob eine gewuenschte KundenNummer noch verfuegbar
		 * ist;
		 */
		for (Integer kundenNummer : KundenStrukturen.mapAlleKundenMap.keySet()) {
			if (kundenNummer == eingabeStringZuInt) {
				throw new FehlerTest("Die Kundennummer " + kundenNummer + " ist schon vergeben.\n"
						+ "Gib bitte eine andere Kundennummer ein.");
			}
		}
	}

	public static void checkIfKundenNummerDoesExist(int eingabeStringZuInt) throws FehlerTest {
		/*
		 * Diese Methode ueberprueft ob der gewuenschte Kunde existiert;
		 */
		boolean finderBool = false;
		for (Integer keyTestInteger : KundenStrukturen.mapAlleKundenMap.keySet()) {
			if (keyTestInteger == eingabeStringZuInt) {
				finderBool = true;
			}
		}
		if (finderBool != true) {
			throw new FehlerTest("Diese Kundennummer existiert nicht");
		}
	}

	public static void checkIfKundenSammlungNameIsAvailable(String eingabeString) throws FehlerTest {
		/*
		 * Diese Methode checkt ob der vom User gewaehlte KundenSammlungsName schon
		 * vergeben ist;
		 */
		for (Integer key : KundenStrukturen.mapAlleKundenStrukturen.keySet()) {
			if (KundenStrukturen.mapAlleKundenStrukturen.get(key).kundenSammlungNameString.equals(eingabeString)) {
				throw new FehlerTest("Dieser Name ist schon vergeben");
			}
		}

	}

	public static void checkIfKundenSammlungNummerIsAvailable(int eingabeStringZuInt) throws FehlerTest {
		/*
		 * Diese Methode ueberprueft ob die vom User gewaehlte KundenSammlungsNummer
		 * schon vergeben ist;
		 */
		for (Integer key : KundenStrukturen.mapAlleKundenStrukturen.keySet()) {
			if (eingabeStringZuInt == key) {
				throw new FehlerTest("Die Nummer " + eingabeStringZuInt + " ist schon vergeben");
			}
		}
	}

	public static void checkIfKundenSammlungNummerDoesExist(int eingabeStringZuInt) throws FehlerTest {
		/*
		 * Diese Methode checkt ob die zum Aufrufen gewuenschte KundenSammlungsNummer
		 * existiert;
		 */
		boolean testBool = false;
		for (Integer key : KundenStrukturen.mapAlleKundenStrukturen.keySet()) {
			if (key == eingabeStringZuInt) {
				testBool = true;
			}
		}
		if (testBool != true) {
			throw new FehlerTest("Diese Kundensammlung existiert nicht");
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

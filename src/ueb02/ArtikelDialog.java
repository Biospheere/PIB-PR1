package ueb02;

import java.util.Scanner;

public class ArtikelDialog {

    private Artikel artikel = null;

    /**
     * Methode zum interaktiven Testen der Artikel Klasse
     */
    public void readInput() {
        try (final Scanner scanner = new Scanner(System.in)) {
            while (true) {
                final String input = readString(scanner, "Command: ").toLowerCase().trim();
                if (artikel == null && !input.equalsIgnoreCase("erstellen")) {
                    System.out.println("Es wurde noch kein Artikel mit *erstellen* erstellt!");
                    continue;
                }
                executeCommand(scanner, input);
            }
        }
    }

    /**
     * Führt den eingebenen Befehl aus
     * 
     * @param scanner das genutzte Scanner Objekt
     * @param input   der eingebene Command
     */
    private void executeCommand(final Scanner scanner, String input) {
        try {
            switch (input) {
                case "erstellen":
                    if (artikel != null) {
                        final String mode = readString(scanner,
                                "Soll der aktuelle Artikel überschrieben werden? (Ja/Nein)").toLowerCase();
                        if (mode.equals("nein") || !mode.equals("ja")) {
                            System.out.println("Artikel wird nicht überschrieben");
                            break;
                        }
                    }
                    artikel = createArtikel(scanner);
                    break;
                case "abgang":
                    artikel.bucheAbgang(readNumber(scanner, "Betrag: "));
                    break;
                case "zugang":
                    artikel.bucheZugang(readNumber(scanner, "Betrag: "));
                    break;
                case "art":
                    artikel.setArt(readString(scanner, "Art: "));
                    break;
                case "ausgeben":
                    System.out.println(artikel);
                    break;
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Fehler: " + exception.getMessage());
        }
    }

    /**
     * Erstellt ein neues Artikel Objekt
     * 
     * @param scanner das genutzte Scanner Objekt
     * @return das erstellte Artikel Objekt
     */
    private Artikel createArtikel(Scanner scanner) {
        final String constructor = readString(scanner,
                "Soll der Konstruktor mit allen Paramtern genutzt werden? (Ja/Nein): ");
        final int artikelnr = readNumber(scanner, "Artikelnummer: ");
        final String art = readString(scanner, "Art: ");
        if (constructor.equalsIgnoreCase("Ja")) {
            final int bestand = readNumber(scanner, "Bestand: ");
            return new Artikel(artikelnr, art, bestand);
        } else {
            return new Artikel(artikelnr, art);
        }
    }

    /**
     * Wartet bis der Nutzer eine Nummer eingegeben hat
     * 
     * @param scanner
     * @param promtMessage
     * @return die eingegebene Nummer
     */
    private int readNumber(final Scanner scanner, final String promtMessage) {
        System.out.print(promtMessage);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.print(promtMessage);
        }
        final int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    /**
     * @param scanner      das genutzte Scanner Objekt
     * @param promtMessage
     * @return der eingegebene String
     */
    private String readString(final Scanner scanner, final String promtMessage) {
        System.out.print(promtMessage);
        return scanner.nextLine();
    }

    public static void main(String... args) {
        new ArtikelDialog().readInput();
    }

}

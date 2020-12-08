package ueb05;

import java.util.Optional;
import java.util.Scanner;

public class LagerDialog {

    private Lager lager = null;

    /**
     * Methode zum interaktiven Testen der Artikel Klasse
     */
    public void readInput() {
        try (final Scanner scanner = new Scanner(System.in)) {
            while (true) {
                final String input = readString(scanner, "Command: ").toLowerCase().trim();
                if (lager == null && (!input.equalsIgnoreCase("erstellen") && !input.equalsIgnoreCase("stop"))) {
                    System.out.println("Es wurde noch kein Lager mit *erstellen* erstellt!");
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
                    if (lager != null) {
                        final String mode = readString(scanner,
                                "Soll das aktuelle Lager überschrieben werden? (Ja/Nein)").toLowerCase();
                        if (mode.equals("nein") || !mode.equals("ja")) {
                            System.out.println("Lager wird nicht überschrieben");
                            break;
                        }
                    }
                    lager = new Lager(readInt(scanner, "Größe des Lagers: "));
                    break;
                case "anlegen":
                    lager.legeAnArtikel(createArtikel(scanner));
                    break;
                case "entferne":
                    lager.entferneArtikel(readInt(scanner, "Artikelnummer: "));
                    break;
                case "zugang":
                    lager.bucheZugang(readInt(scanner, "Artikelnummer: "), readInt(scanner, "Menge: "));
                    break;
                case "abgang":
                    lager.bucheAbgang(readInt(scanner, "Artikelnummer: "), readInt(scanner, "Menge: "));
                    break;
                case "preis":
                    lager.aenderePreisAllerArtikel(readDouble(scanner, "Prozent: "));
                    break;
                case "get":
                    final String mode = readString(scanner, "Index/Nummer: ").toLowerCase();
                    if (mode.equals("index")) {
                        System.out.println(lager.getArtikel(readInt(scanner, "Index: ")));
                    } else if (mode.equals("nummer")) {
                        Optional<Artikel> artikel = lager.getArtikelByNr(readInt(scanner, "Nummer: "));
                        if (artikel.isPresent()) {
                            System.out.println(artikel.get());
                        } else {
                            System.out.println("Artikel existiert nicht");
                        }
                    }
                    break;
                case "artikelanzahl":
                    System.out.println(lager.getArtikelAnzahl());
                    break;
                case "lagergröße":
                    System.out.println(lager.getLagerGroesse());
                    break;
                case "ausgeben":
                    System.out.println(lager);
                    break;
                case "stop":
                    System.exit(0);
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
        final int artikelnr = readInt(scanner, "Artikelnummer: ");
        final String art = readString(scanner, "Art: ");
        final int bestand = readInt(scanner, "Bestand: ");
        final double price = readDouble(scanner, "Preis: ");
        return bestand == 0 ? new Artikel(artikelnr, art, price) : new Artikel(artikelnr, art, bestand, price);
    }

    /**
     * Wartet bis der Nutzer eine Nummer eingegeben hat
     * 
     * @param scanner
     * @param promtMessage
     * @return die eingegebene Nummer
     */
    private int readInt(final Scanner scanner, final String promtMessage) {
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
     * Wartet bis der Nutzer eine Nummer eingegeben hat
     * 
     * @param scanner
     * @param promtMessage
     * @return die eingegebene Nummer
     */
    private double readDouble(final Scanner scanner, final String promtMessage) {
        System.out.print(promtMessage);
        while (!scanner.hasNextDouble()) {
            scanner.nextLine();
            System.out.print(promtMessage);
        }
        final double number = scanner.nextDouble();
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
        new LagerDialog().readInput();
    }

}

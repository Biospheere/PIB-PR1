package ueb02;

import java.util.Scanner;

public class ArtikelTest {

    private Artikel artikel = null;

    public void readInput() {
        try (final Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Command: ");
                final String input = scanner.nextLine().toLowerCase().trim();
                if (artikel == null && !input.equalsIgnoreCase("erstellen")) {
                    continue;
                }
                switch (input) {
                    case "erstellen":
                        artikel = createArtikel(scanner);
                        break;
                    case "abgang":
                        System.out.print("Betrag: ");
                        artikel.bucheAbgang(readNumber(scanner));
                        break;
                    case "zugang":
                        System.out.print("Betrag: ");
                        artikel.bucheZugang(readNumber(scanner));
                        break;
                    case "art":
                        System.out.print("Art: ");
                        final String art = scanner.nextLine();
                        artikel.setArt(art);
                        break;
                    case "ausgeben":
                        System.out.println(artikel);
                        break;
                }
            }
        }
    }

    private Artikel createArtikel(Scanner scanner) {
        System.out.print("Artikelnummer: ");
        final int artikelnr = readNumber(scanner);
        System.out.print("Art: ");
        final String art = scanner.nextLine();
        System.out.print("Bestand: ");
        final int bestand = readNumber(scanner);
        return bestand == 0 ? new Artikel(artikelnr, art) : new Artikel(artikelnr, art, bestand);
    }

    private int readNumber(final Scanner scanner) {
        final int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static void main(String... args) {
        new ArtikelTest().readInput();
    }

}

package ueb04;

import java.util.Scanner;

public class MathDialog {

    /**
     * Methode zum interaktiven Testen der MathFunctions Klasse
     */
    public void readInput() {
        System.out.println(
                "Teilersumme berechnen: teilsumme\nISBN Pruefsumme berechnen: isbn\nNullstelle berechnen: nullstellen\nSumme von Potenzen: potenz\nProgramm beenden: stop");
        try (final Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    switch (readString(scanner, "Command: ").toLowerCase().trim()) {
                        case "teilsumme":
                            System.out.println(MathFunctions.berechneTeilersumme(readLong(scanner, "Zahl: ")));
                            break;
                        case "isbn":
                            System.out.println("Die Prüfziffer ist "
                                    + MathFunctions.berechneChecksummeIsbn(readLong(scanner, "ISBN-10: ")));
                            break;
                        case "nullstellen":
                            System.out.println(MathFunctions.berechneNullstellen(readDouble(scanner, "P: "),
                                    readDouble(scanner, "Q:")));
                            break;
                        case "potenz":
                            boolean result = MathFunctions.istSummeVonPotenzen(readLong(scanner, "Zahl: "));
                            System.out.println(result ? "Die angebene Zahl lässt sich als Summe von Potenzen darstellen"
                                    : "Die angebene Zahl lässt sich nicht als Summe von Potenzen darstellen");
                            break;
                        case "stop":
                            System.exit(0);
                    }
                } catch (IllegalArgumentException exception) {
                    System.out.println("Fehler: " + exception.getMessage());
                }
            }
        }
    }

    /**
     * Wartet bis der Nutzer eine Nummer eingegeben hat
     *
     * @param scanner
     * @param promtMessage
     * @return die eingegebene Nummer
     */
    private long readLong(final Scanner scanner, final String promtMessage) {
        System.out.print(promtMessage);
        while (!scanner.hasNextLong()) {
            scanner.nextLine();
            System.out.print(promtMessage);
        }
        final long number = scanner.nextLong();
        scanner.nextLine();
        return number;
    }

    /**
     * Wartet bis der Nutzer einen Double eingegeben hat
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
        new MathDialog().readInput();
    }

}
package ueb03;

import java.util.Scanner;

public class MathDialog {

    /**
     * Methode zum interaktiven Testen der MathFunctions Klasse
     */
    public void readInput() {
        try (final Scanner scanner = new Scanner(System.in)) {
            while (true) {
                switch (readString(scanner, "Command: ").toLowerCase().trim()) {
                    case "teilsumme":
                        System.out.println(MathFunctions.berechneTeilersumme(readNumber(scanner, "Zahl: ")));
                        break;
                    case "isbn":
                        System.out.println(MathFunctions.berechneChecksummeIsbn(readNumber(scanner, "ISBN-10: ")));
                        break;
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
    private long readNumber(final Scanner scanner, final String promtMessage) {
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

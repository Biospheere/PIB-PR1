package ueb03;

public class MathFunctions {

    /**
     * Berechnet die Teilsumme einer zahl
     * @param zahl die Zahl zu der die Teilsumme berechnet werden soll
     * @return die berechnete Teilsumme
     */
    public static long berechneTeilersumme(long zahl) {
        long result = 0;
        for (int i = 1; i <= zahl; i++) {
            if (zahl % i == 0) {
                result += i;
            }
        }
        return result;
    }

    /**
     * Berechnet die Prüfziffer einer ISBN-10
     * @param isbn die zu prüfende ISBN-10
     * @return die Prüfsummen der ISBN. Wenn Prüfsumme 1ß ist wird x zurückgegeben
     */
    public static String berechneChecksummeIsbn(long isbn) {
        int sum = 0;
        int count = 9;
        while (isbn > 0) {
            sum += count * (isbn % 10);
            isbn = isbn / 10;
            count--;
        }
        final int mod = (sum % 11);
        return mod == 10 ? "X" : String.valueOf(mod);
    }

}

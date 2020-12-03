package ueb04;

public class MathFunctions {

    /**
     * Berechnet die Teilsumme einer Zahl
     * 
     * @param zahl die Zahl zu der die Teilsumme berechnet werden soll
     * @return die berechnete Teilsumme
     * @throws IllegalArgumentException Wenn <code>zahl</code> kleiner 1 ist
     */
    public static long berechneTeilersumme(long zahl) {
        if (zahl < 1) {
            throw new IllegalArgumentException("Zahl muss größer als 0 sein");
        }
        if (zahl == 1) {
            return 1;
        }
        long result = zahl + 1;
        long max = zahl;
        for (long i = 2; i < max; i++) {
            if (zahl % i == 0) {
                max = (zahl / i);
                result += i;
                if (max != i) {
                    result += max;
                }
            } else {
                max = (zahl / i) + 1;
            }
        }
        return result;
    }

    /**
     * Berechnet die Prüfziffer einer ISBN-10
     * 
     * @param isbn die zu prüfende ISBN-10
     * @return die Prüfsummen der ISBN. Wenn die Prüfsumme 10 ist wird X
     *         zurückgegeben
     * @throws IllegalArgumentException Wenn <code>isbn</code> nicht 9 stellig ist
     */
    public static String berechneChecksummeIsbn(long isbn) {
        if (isbn < 100000000 || isbn > 999999999) {
            throw new IllegalArgumentException("ISBN muss 9 Ziffern haben");
        }
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

    /**
     * Berechnet die Nullstellen einer Quadratischen Gleichung
     * 
     * @param p aus der Normalform der Quadratischen Gleichung
     * @param q aus der Normalform der Quadratischen Gleichung
     * @return das Ergenis der Rechnung
     */
    public static String berechneNullstellen(double p, double q) {
        final double diskriminante = (p / 2) * (p / 2) - q;
        if (diskriminante > 0) {
            final double x1 = -(p / 2) + Math.sqrt(diskriminante);
            final double x2 = -(p / 2) - Math.sqrt(diskriminante);
            return "Zwei Nullstellen: " + x1 + " | " + x2;
        } else if (diskriminante < 0) {
            return "Komplexe Nullstellen";
        }
        final double x1 = -(p / 2) + Math.sqrt(diskriminante);
        return "Doppelte Nullstelle: " + x1;
    }

    /**
     * Überprüft ob es Zahlen a,b,c für die gilt
     * <code>zahl</code> = a^4 + b^3 + c^2
     * @param zahl die Zahl die getestet werden soll
     * @return Ob die genannte Bedingung erfüllt ist
     * @throws IllegalArgumentException Wenn <code>zahl</code> kleiner 1 ist
     */
    public static boolean istSummeVonPotenzen(long zahl) {
        if (zahl < 1) {
            throw new IllegalArgumentException("Zahl muss größer als 0 sein");
        }
        for (int a = 1; a <= Math.pow(zahl, 1.0 / 4.0); a++) {
            for (int b = 1; b <= Math.cbrt(zahl); b++) {
                double c = (zahl - (Math.pow(a, 4) + Math.pow(b, 3)));
                if (c % Math.sqrt(c) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}

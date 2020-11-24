public class ThirdExcercise {

    public static void main(String... args) {
        printTripel(50);
        int i = 5 / 0;
        System.out.println(i);
    }

    /**
     * Gibt alle Zahlentripel aus für die folgende Eigenschaften gelten
     * a^3 + b^3 = c^2 
     * 0 < a <= b
     * c < max
     * @param max obere Schranke für die Zahlentripel
     */    
    public static void printTripel(int max) {
        if (max < 1) {
            throw new IllegalArgumentException("Zahl muss positiv sein");
        }
        for (int a = 0; a < max; a++) {
            for (int b = 0; b < max; b++) {
                for (int c = 0; c < max; c++) {
                    final double resultLeft = Math.pow(a, 3) + Math.pow(b, 3);
                    final double resultRight = Math.pow(c, 2);

                    boolean a1 = (resultLeft == resultRight);
                    boolean a2 = (a > 0) && (a <= b);
                    boolean a3 = (c < max);
                    if (a1 && a2 && a3) {
                        System.out.printf("(%d, %d, %d))\n", a, b, c);
                    }
                }
            }
        }
    }

}

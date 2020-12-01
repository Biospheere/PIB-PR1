public class ThirdExcercise {

    public static void main(String... args) {
        koeffizienten(10000, -1, 4);
    }

    public static void koeffizienten(int max, int a, int b) {
        if (max < 1) {
            throw new IllegalArgumentException("Schranke muss positiv sein");
        }
        for (int x = 0; x < max; x++) {
            double right = Math.pow(x, 3) + (a * x) + b;
            System.out.printf("(%d,%d)\n", x, (int) Math.sqrt(right));
        }
    }

}

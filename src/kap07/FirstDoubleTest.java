package kap07;

public class FirstDoubleTest {

    public static void main(String... args) {
        double x = -1.0;
        while (x <= 0.0) {
            System.out.println(x);
            x += 0.1;
        }
        System.out.println("\n0.01 - 0.1 * 0.1 = " + (0.01 - 0.1 * 0.1));
    }

}

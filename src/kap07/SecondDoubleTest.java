package kap07;

public class SecondDoubleTest {

    public static void main(String... args) {
        final double a = 1.0, b = 1.0E16, c = -b;
        final double x = (a + b) + c;
        final double y = a + (b + c);
        System.out.println("(a + b) + c = " + x);
        System.out.println("a + (b + c) = " + y);
    }

}

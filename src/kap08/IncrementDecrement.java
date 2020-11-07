package kap08;

public class IncrementDecrement {

    public static void main(String... args) {
        int a = 1;
        int b = a++; // 2 1
        System.out.println("a = " + a + ", b = " + b);

        int c = 1;
        int d = --c; // 0 0
        System.out.println("c = " + c + ", d = " + d);

        double x = 2.5;
        double y = x--; // 1,5 2.5
        System.out.println("x = " + x + ", y = " + y);

        a = b = 1;
        c = -a-- - --b; // -1
        System.out.println("c = " + c);
    }

}

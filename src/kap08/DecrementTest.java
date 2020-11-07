package kap08;

public class DecrementTest {

    public static void main(String... args) {
        int i = 5;
        while (i-- > 0) {
            System.out.print(i + "  "); // 4 3 2 1 0
        }
        System.out.println();
        i = 5;
        while (--i > 0) {
            System.out.print(i + "  "); // 4 3 2 1
        }
    }

}
